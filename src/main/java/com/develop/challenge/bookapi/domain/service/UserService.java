package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.exception.DataNotFoundException;
import com.develop.challenge.bookapi.domain.exception.NotificationCodeType;
import com.develop.challenge.bookapi.domain.model.RoleType;
import com.develop.challenge.bookapi.domain.model.User;
import com.develop.challenge.bookapi.domain.port.external.NotificationExternalPort;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import com.develop.challenge.bookapi.domain.port.repository.UserRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserExternalPort userExternalPort;
    private final UserRepositoryPort userRepositoryPort;
    private final OTPService otpService;
    private final NotificationExternalPort notificationExternalPort;

    public void requestActivation(String email) {
        User savedUser = userExternalPort.findByEmail(email).map(user -> {
            String temporalPassword = otpService.generate();
            user.setEnable(true);
            user.setRole(RoleType.ROLE_USER);
            userRepositoryPort.encryptPasswordAndSave(user, temporalPassword);
            notificationExternalPort.sendOtpEmail(email, temporalPassword);
            return user;
        }).orElseThrow(() -> new DataNotFoundException(NotificationCodeType.NOT_FOUND_EXTERNAL_USER));

        log.info("Activation requested for user with ID [{}]", savedUser.getId());
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        User updatedUser = userRepositoryPort.findByUsernameAndPassword(username, oldPassword).map(user -> {
            user.setEnable(true);
            userRepositoryPort.encryptPasswordAndSave(user, newPassword);
            return user;
        }).orElseThrow(() -> new DataNotFoundException(NotificationCodeType.NOT_FOUND_CREDENTIALS_USER));

        log.info("User password with ID [{}] was changed", updatedUser.getId());
    }

}
