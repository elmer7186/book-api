package com.develop.challenge.bookapi.infrastructure.adapter.external;

import com.develop.challenge.bookapi.domain.model.comment.Comment;
import com.develop.challenge.bookapi.domain.port.external.CommentExternalPort;
import com.develop.challenge.bookapi.infrastructure.adapter.external.delegate.CommentDelegateClient;
import com.develop.challenge.bookapi.infrastructure.adapter.external.mapper.CommentExternalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CommentExternalAdapter implements CommentExternalPort {

    private final CommentDelegateClient commentDelegateClient;
    private final CommentExternalMapper commentExternalMapper;

    @Override
    public List<Comment> findByEmail(String email) {
        return commentExternalMapper.dtoToDomainList(
                commentDelegateClient.findAll().stream()
                        .filter(commentExternalDto -> commentExternalDto.getEmail().equals(email))
                        .collect(Collectors.toList()));
    }

    @Override
    public List<Comment> findByName(String name) {
        return commentExternalMapper.dtoToDomainList(
                commentDelegateClient.findAll().stream()
                        .filter(commentExternalDto -> commentExternalDto.getName().equals(name))
                        .collect(Collectors.toList()));
    }

    @Override
    public List<Comment> findAll() {
        return commentExternalMapper.dtoToDomainList(commentDelegateClient.findAll());
    }

}
