package com.develop.challenge.bookapi.infrastructure.adapter.external.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GeoExternalDto {

    private String lat;
    private String lng;

}
