package com.develop.challenge.bookapi.infrastructure.controller;

import com.develop.challenge.bookapi.application.dto.comment.CommentDto;
import com.develop.challenge.bookapi.application.service.CommentAppService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.develop.challenge.bookapi.infrastructure.controller.constants.ApiConstants.COMMENTS_V1;

@AllArgsConstructor
@RestController
@RequestMapping(COMMENTS_V1)
public class CommentController {

    private final CommentAppService commentAppService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "userId", required = false, defaultValue = "0") int userId) {
        return ResponseEntity.ok(commentAppService.findByNameOrUserId(name, userId));
    }

}
