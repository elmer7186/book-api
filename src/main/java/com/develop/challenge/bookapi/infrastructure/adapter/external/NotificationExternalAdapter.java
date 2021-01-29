package com.develop.challenge.bookapi.infrastructure.adapter.external;

import com.develop.challenge.bookapi.domain.port.external.NotificationExternalPort;
import com.develop.challenge.bookapi.infrastructure.adapter.external.delegate.NotificationDelegateClient;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.notification.EmailExternalDto;
import com.develop.challenge.bookapi.infrastructure.config.OtpPropertiesConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@AllArgsConstructor
@Component
public class NotificationExternalAdapter implements NotificationExternalPort {

    private final NotificationDelegateClient notificationDelegateClient;
    private final OtpPropertiesConfig otpPropertiesConfig;

    @Override
    public void sendOtpEmail(String email, String otp) {
        notificationDelegateClient.sendEmail(
                new EmailExternalDto(
                        email,
                        otpPropertiesConfig.getSubject(),
                        MessageFormat.format(otpPropertiesConfig.getMessage(), otp)));
    }

}
