package com.develop.challenge.bookapi.infrastructure.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Setter
@Getter
public class AuthenticatedUser extends User {

    private long userId;

    public AuthenticatedUser(String username, String password, long userId,
                             boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, true, true,
                true, authorities);
        this.userId = userId;
    }
}
