package com.develop.challenge.bookapi.application.dto.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumDto {

    private long id;
    private long userId;
    private String title;

}
