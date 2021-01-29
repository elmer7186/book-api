package com.develop.challenge.bookapi.infrastructure.adapter.external.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserExternalDto {

    private long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private AddressExternalDto address;
    private CompanyExternalDto company;

}
