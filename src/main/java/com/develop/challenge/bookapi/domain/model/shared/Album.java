package com.develop.challenge.bookapi.domain.model.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Album {

    private long id;
    private long userId;
    private String title;

}
