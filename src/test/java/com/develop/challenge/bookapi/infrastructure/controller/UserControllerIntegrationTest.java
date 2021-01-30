package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.PasswordResetDto;
import com.develop.challenge.bookapi.application.dto.UserActivationDto;
import com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    public static final String USER_EMAIL = "test@test.com";
    public static final String USERNAME = "test";
    public static final String OLD_PASSWORD = "Test123*";
    public static final String NEW_PASSWORD = "Changed456*";

    @Test
    void shouldRequestActivationWhenItsCalled() throws Exception {
        // arrange
        UserActivationDto userActivationDto = UserActivationDto.builder().email(USER_EMAIL).build();

        // act - assert
        mockMvc.perform(put(ApiConstants.USERS_V1 + ApiConstants.RESOURCE_USERS_REQUEST_ACTIVE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userActivationDto)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldChangePasswordWhenItsCalled() throws Exception {
        // arrange
        PasswordResetDto passwordResetDto =
                PasswordResetDto.builder().username(USERNAME)
                        .oldPassword(OLD_PASSWORD).newPassword(NEW_PASSWORD)
                        .build();

        // act - assert
        mockMvc.perform(patch(ApiConstants.USERS_V1 + ApiConstants.RESOURCE_USERS_CHANGE_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(passwordResetDto)))
                .andExpect(status().isOk());
    }
}