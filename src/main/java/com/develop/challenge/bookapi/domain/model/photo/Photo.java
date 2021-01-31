package com.develop.challenge.bookapi.domain.model.photo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Photo {

    private long id;
    private long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}
