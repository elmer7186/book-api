package com.develop.challenge.bookapi.infrastructure.config.security;

import com.develop.challenge.bookapi.domain.model.User;
import com.develop.challenge.bookapi.domain.port.repository.UserRepositoryPort;
import com.develop.challenge.bookapi.infrastructure.exception.TechnicalNotificationCodeType;
import com.develop.challenge.bookapi.infrastructure.exception.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepositoryPort userRepositoryPort;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepositoryPort.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException(TechnicalNotificationCodeType.ACCESS_DENIED));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(username,
                user.getPassword(), user.isEnable(), true, true,
                true, authorities);
    }
}
