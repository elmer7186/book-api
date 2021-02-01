package com.develop.challenge.bookapi.infrastructure.adapter.external.dto.album;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumExternalDto {

    private long id;
    private long userId;
    private String title;

}
