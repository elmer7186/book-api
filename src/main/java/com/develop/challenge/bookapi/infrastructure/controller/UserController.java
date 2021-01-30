package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.UserActivationDto;
import com.develop.challenge.bookapi.application.service.UserAppService;
import com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping(value = ApiConstants.USERS_V1)
@RestController
public class UserController {

    private final UserAppService userAppService;

    @PutMapping(value = ApiConstants.RESOURCE_USERS_REQUEST_ACTIVE)
    public ResponseEntity<Boolean> requestActivation(@RequestBody UserActivationDto userActivationDto) {
        userAppService.requestActivation(userActivationDto);
        return ResponseEntity.ok(true);
    }


}
