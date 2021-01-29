package com.develop.challenge.bookapi.infrastructure.adapter.external.delegate;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.notification.EmailExternalDto;
import com.develop.challenge.bookapi.infrastructure.adapter.external.feign.NotificationFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class NotificationDelegateClient {

    private final NotificationFeignClient notificationFeignClient;

    public void sendEmail(EmailExternalDto emailExternalDto) {
        notificationFeignClient.sendEmail(emailExternalDto);
    }

}
