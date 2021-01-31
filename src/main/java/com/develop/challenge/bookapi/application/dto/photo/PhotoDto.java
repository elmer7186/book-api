package com.develop.challenge.bookapi.application.dto.photo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PhotoDto {

    private long id;
    private long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}
