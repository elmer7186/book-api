package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.comment.CommentDto;
import com.develop.challenge.bookapi.application.mapper.CommentAppMapper;
import com.develop.challenge.bookapi.domain.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CommentAppService {

    private CommentService commentService;
    private CommentAppMapper commentAppMapper;

    public List<CommentDto> findByNameOrUserId(String name, int userId) {
        return commentAppMapper.domainToDtoList(commentService.findByNameOrUserId(name, userId));
    }
}
