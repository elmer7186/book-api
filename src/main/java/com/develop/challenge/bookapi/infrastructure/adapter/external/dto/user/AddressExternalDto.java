package com.develop.challenge.bookapi.infrastructure.adapter.external.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressExternalDto {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoExternalDto geo;

}
