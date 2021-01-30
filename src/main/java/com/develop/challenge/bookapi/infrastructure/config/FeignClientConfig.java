package com.develop.challenge.bookapi.infrastructure.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Slf4j
@Configuration
@EnableFeignClients("com.develop.challenge.bookapi.infrastructure.adapter.external.feign")
public class FeignClientConfig {

    public static final String DEFAULT_CHARSET_URL = "UTF-8";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            try {
                template.uri(URLDecoder.decode(
                        template.request().url(),
                        DEFAULT_CHARSET_URL));
            } catch (UnsupportedEncodingException e) {
                log.error("Unsupported encoding for " + DEFAULT_CHARSET_URL, e);
            }
        };
    }

}