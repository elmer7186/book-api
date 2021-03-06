package com.develop.challenge.bookapi.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Getter
@Setter
@Component
@ConfigurationProperties("otp.notification")
public class OtpPropertiesConfig {

    private String subject;
    private String message;

}
