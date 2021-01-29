package com.develop.challenge.bookapi.infrastructure.adapter.external;

import com.develop.challenge.bookapi.domain.port.external.NotificationExternalPort;
import com.develop.challenge.bookapi.infrastructure.adapter.external.delegate.NotificationDelegateClient;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.notification.EmailExternalDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class NotificationExternalAdapter implements NotificationExternalPort {

    private final NotificationDelegateClient notificationDelegateClient;

    @Override
    public void sendEmail(String recipient, String subject, String message) {
        notificationDelegateClient.sendEmail(new EmailExternalDto(recipient, subject, message));
    }

}
