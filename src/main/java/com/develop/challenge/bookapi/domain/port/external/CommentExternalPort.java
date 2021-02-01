package com.develop.challenge.bookapi.domain.port.external;

import com.develop.challenge.bookapi.domain.model.comment.Comment;

import java.util.List;

public interface CommentExternalPort {

    /**
     * Find comments by user email
     *
     * @param email user email
     * @return domain model list
     */
    List<Comment> findByEmail(String email);

    /**
     * Find comments by user name
     *
     * @param name comment name
     * @return domain model list
     */
    List<Comment> findByName(String name);

    /**
     * Find all comments
     *
     * @return domain model list
     */
    List<Comment> findAll();
}
