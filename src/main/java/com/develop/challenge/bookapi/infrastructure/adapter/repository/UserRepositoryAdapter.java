package com.develop.challenge.bookapi.infrastructure.adapter.repository;

import com.develop.challenge.bookapi.domain.model.User;
import com.develop.challenge.bookapi.domain.port.repository.UserRepositoryPort;
import com.develop.challenge.bookapi.infrastructure.adapter.repository.jpa.UserJpaRepository;
import com.develop.challenge.bookapi.infrastructure.adapter.repository.mapper.UserRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private UserJpaRepository userJpaRepository;
    private UserRepositoryMapper userRepositoryMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        userJpaRepository.save(userRepositoryMapper.domainToEntity(user));
    }

    @Override
    public void encryptPasswordAndSave(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        save(user);
    }
}
