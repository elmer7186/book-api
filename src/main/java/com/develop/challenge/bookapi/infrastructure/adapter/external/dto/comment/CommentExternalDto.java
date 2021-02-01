package com.develop.challenge.bookapi.infrastructure.adapter.external.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentExternalDto {

    private long id;
    private long postId;
    private String name;
    private String email;
    private String body;

}
