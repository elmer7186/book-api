package com.develop.challenge.bookapi.domain.model.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Comment {

    private long id;
    private long postId;
    private String name;
    private String email;
    private String body;

}
