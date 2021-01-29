package com.develop.challenge.bookapi.infrastructure.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.develop.challenge.bookapi.infrastructure.adapter.external.feign")
public class FeignClientConfig {
}
