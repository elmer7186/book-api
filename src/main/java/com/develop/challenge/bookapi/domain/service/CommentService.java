package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.model.comment.Comment;
import com.develop.challenge.bookapi.domain.model.user.User;
import com.develop.challenge.bookapi.domain.port.external.CommentExternalPort;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

@AllArgsConstructor
@Component
public class CommentService {

    private final UserExternalPort userExternalPort;
    private final CommentExternalPort commentExternalPort;

    public List<Comment> findByNameOrUserId(String name, int userId) {
        if (isNoneBlank(name)) {
            return commentExternalPort.findByName(name);
        } else if (userId != 0) {
            Optional<User> user = userExternalPort.findById(userId);
            if (!user.isPresent()) {
                return Collections.emptyList();
            }
            return commentExternalPort.findByEmail(user.get().getEmail());
        } else {
            return commentExternalPort.findAll();
        }
    }

}
