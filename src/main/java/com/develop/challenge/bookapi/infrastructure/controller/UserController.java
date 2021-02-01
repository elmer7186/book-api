package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.user.PasswordResetDto;
import com.develop.challenge.bookapi.application.dto.user.UserActivationDto;
import com.develop.challenge.bookapi.application.dto.user.UserDto;
import com.develop.challenge.bookapi.application.service.UserAppService;
import com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.RESOURCE_USERS_CHANGE_PASSWORD;
import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.RESOURCE_USERS_REQUEST_ACTIVE;

@AllArgsConstructor
@RequestMapping(value = ApiConstants.USERS_V1)
@RestController
public class UserController {

    private final UserAppService userAppService;

    @PutMapping(value = RESOURCE_USERS_REQUEST_ACTIVE)
    public ResponseEntity<Boolean> requestActivation(@RequestBody UserActivationDto userActivationDto) {
        userAppService.requestActivation(userActivationDto);
        return ResponseEntity.ok(true);
    }

    @PatchMapping(value = RESOURCE_USERS_CHANGE_PASSWORD)
    public ResponseEntity<Boolean> changePassword(@RequestBody PasswordResetDto passwordResetDto) {
        userAppService.changePassword(passwordResetDto);
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userAppService.findAll());
    }

}
