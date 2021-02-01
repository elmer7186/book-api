package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.shared.SharedDto;
import com.develop.challenge.bookapi.application.dto.user.UserDto;
import com.develop.challenge.bookapi.application.service.SharedAppService;
import com.develop.challenge.bookapi.infrastructure.config.security.AuthenticatedUser;
import com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.RESOURCE_GET_USERS_SHARED_BY_ALBUMS_ID;

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

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(RESOURCE_GET_USERS_SHARED_BY_ALBUMS_ID)
    public ResponseEntity<List<UserDto>> findUsersByAlbumId(@PathParam("albumId") long albumId) {
        AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder
                .getContext().getAuthentication().getDetails();
        return ResponseEntity.ok(sharedAppService.findUsersByAlbumId(albumId,
                authenticatedUser.getUserId()));
    }

}
