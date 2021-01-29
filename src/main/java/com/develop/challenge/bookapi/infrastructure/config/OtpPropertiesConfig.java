package com.develop.challenge.bookapi.infrastructure.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Getter
@Component
@ConfigurationProperties(prefix = "otp.notification")
public class OtpPropertiesConfig {

    private String subject;
    private String message;

}
