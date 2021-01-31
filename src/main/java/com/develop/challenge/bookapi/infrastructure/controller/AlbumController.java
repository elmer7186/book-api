package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.shared.AlbumDto;
import com.develop.challenge.bookapi.application.service.AlbumAppService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.ALBUMS_V1;

@AllArgsConstructor
@RestController
@RequestMapping(ALBUMS_V1)
public class AlbumController {

    private final AlbumAppService albumAppService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<AlbumDto>> findAll() {
        return ResponseEntity.ok(albumAppService.findAll());
    }

}
