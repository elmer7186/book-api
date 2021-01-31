package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.photo.PhotoDto;
import com.develop.challenge.bookapi.application.service.PhotoAppService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.PHOTOS_V1;

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

}
