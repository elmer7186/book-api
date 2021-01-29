package com.develop.challenge.bookapi.infrastructure.config;

import com.develop.challenge.bookapi.infrastructure.util.FileUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Slf4j
@Configuration
@RefreshScope
@ConditionalOnProperty(value = "wiremock.enabled", havingValue = "true")
public class LocalWireMockConfig {

    @Value("${wiremock.server.port}")
    private int wireMockPort;

    @Value("${wiremock.server.matchPort:''}")
    private String wireMockPortEnabled;

    @Value("${server.port}")
    private String serverPort;

    private static final String RESPONSE_USER_WAREHOUSE_BY_EMAIL = "/json/warehouse/user-with-test-email-response.json";

    // warehouse resources
    private static final String URL_RESOURCE_USERS_WITH_EMAIL = "/users?email=test@test.com";

    // notification resources
    private static final String URL_RESOURCE_NOTIFICATIONS = "/notifications";

    private WireMockServer wireMockServer;

    private WireMockServer wireMockServerLocal() {
        log.info("---------- WireMock init ----------");
        boolean wireMockEnabled = Optional.ofNullable(serverPort)
                .map(port -> port.equals(wireMockPortEnabled))
                .orElse(false);

        wireMockServer = new WireMockServer(options()
                .port(wireMockPort)
                .notifier(new Slf4jNotifier(false)));

        if (wireMockEnabled) {
            wireMockServer.start();
            log.info("---------- WireMock started ----------");
        }

        return wireMockServer;
    }

    @PreDestroy
    public void preDestroy() {
        wireMockServer.stop();
        log.info("---------- Wiremock stopped ----------");
    }

    @Bean
    public ApplicationRunner mockExternalService() {
        return args -> {
            wireMockServer = wireMockServerLocal();

            // Notification email service
            wireMockServer.stubFor(
                    post(URL_RESOURCE_NOTIFICATIONS)
                            .willReturn(ok())
            );

            // External service Users find by email 'test@test.com'
            wireMockServer.stubFor(
                    get(URL_RESOURCE_USERS_WITH_EMAIL)
                            .willReturn(
                                    aResponse().withBody(FileUtils.readContent(RESPONSE_USER_WAREHOUSE_BY_EMAIL))));
        };
    }
}
