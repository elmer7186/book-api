package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.exception.DataNotFoundException;
import com.develop.challenge.bookapi.domain.model.User;
import com.develop.challenge.bookapi.domain.port.external.NotificationExternalPort;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import com.develop.challenge.bookapi.domain.port.repository.UserRepositoryPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private static final PodamFactory FACTORY = new PodamFactoryImpl();

    private UserExternalPort userExternalPort;
    private UserRepositoryPort userRepositoryPort;
    private OTPService otpService;
    private NotificationExternalPort notificationExternalPort;
    private UserService userService;

    private static final String USER_EMAIL = "test@test.com";
    private static final String OTP_VALUE = "123456";

    @BeforeEach
    void setUp() {
        userExternalPort = mock(UserExternalPort.class);
        userRepositoryPort = mock(UserRepositoryPort.class);
        otpService = mock(OTPService.class);
        notificationExternalPort = mock(NotificationExternalPort.class);
        userService = new UserService(userExternalPort, userRepositoryPort,
                otpService, notificationExternalPort);
    }

    @Test
    void shouldThrownExceptionWhenRequestActivationEmailNotFound() {
        // arrange
        when(userExternalPort.findByEmail(USER_EMAIL)).thenReturn(Optional.empty());

        // act - assert
        assertThatThrownBy(() -> userService.requestActivation(USER_EMAIL))
                .isInstanceOf(DataNotFoundException.class);
    }

    @Test
    void shouldCallActivationServicesWhenUserExists() {
        // arrange
        User user = FACTORY.manufacturePojo(User.class);
        when(userExternalPort.findByEmail(USER_EMAIL)).thenReturn(Optional.of(user));
        when(otpService.generate()).thenReturn(OTP_VALUE);
        doNothing().when(userRepositoryPort).encryptPasswordAndSave(any(), any());
        doNothing().when(notificationExternalPort).sendOtpEmail(any(), any());

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        // act
        userService.requestActivation(USER_EMAIL);

        // assert
        verify(otpService, times(1)).generate();
        verify(userRepositoryPort, times(1)).encryptPasswordAndSave(userCaptor.capture(), any());
        assertThat(userCaptor.getValue().isEnable()).isTrue();
        verify(notificationExternalPort, times(1)).sendOtpEmail(USER_EMAIL, OTP_VALUE);
    }
}