package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.shared.SharedDto;
import com.develop.challenge.bookapi.application.service.SharedAppService;
import com.develop.challenge.bookapi.infrastructure.config.security.AuthenticatedUser;
import com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(ApiConstants.SHARED_V1)
public class SharedController {

    private SharedAppService sharedAppService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<Boolean> registerShared(@RequestBody SharedDto sharedDto) {
        AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder
                .getContext().getAuthentication().getDetails();
        sharedAppService.registerShared(sharedDto, authenticatedUser.getUserId());
        return ResponseEntity.ok(true);
    }

}
