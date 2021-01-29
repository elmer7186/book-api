package com.develop.challenge.bookapi.infrastructure.adapter.external.feign;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.notification.EmailExternalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "${feign.email.name}", url = "${feign.email.rootUrl}"
)
public interface NotificationFeignClient {

    /**
     * Send email message by external service
     *
     * @param emailExternalDto email content
     */
    @PostMapping(value = "${feign.email.resources.notifications}")
    void sendEmail(@RequestBody EmailExternalDto emailExternalDto);

}
