package com.develop.challenge.bookapi.application.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDto {

    private long id;
    private long postId;
    private String name;
    private String email;
    private String body;

}
