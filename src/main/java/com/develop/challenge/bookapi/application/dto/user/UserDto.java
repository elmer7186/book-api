package com.develop.challenge.bookapi.application.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String email;

}
