package com.develop.challenge.bookapi.domain.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private long id;
    private String name;
    private String username;
    private String password;
    private RoleType role;
    private String email;
    private String phone;
    private String website;
    private boolean enable;

}
