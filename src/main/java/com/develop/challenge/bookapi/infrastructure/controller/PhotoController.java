package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.photo.PhotoDto;
import com.develop.challenge.bookapi.application.service.PhotoAppService;
import com.develop.challenge.bookapi.infrastructure.config.security.AuthenticatedUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.PHOTOS_V1;
import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.RESOURCE_PHOTOS_USER_SESSION;

@AllArgsConstructor
@RestController
@RequestMapping(PHOTOS_V1)
public class PhotoController {

    private final PhotoAppService photoAppService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<PhotoDto>> findAll() {
        return ResponseEntity.ok(photoAppService.findAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(RESOURCE_PHOTOS_USER_SESSION)
    public ResponseEntity<List<PhotoDto>> findByUserSession() {
        AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder
                .getContext().getAuthentication().getDetails();
        return ResponseEntity.ok(photoAppService.findByUserId(authenticatedUser.getUserId()));
    }

}
