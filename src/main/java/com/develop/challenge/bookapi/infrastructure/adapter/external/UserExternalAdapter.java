package com.develop.challenge.bookapi.infrastructure.adapter.external;

import com.develop.challenge.bookapi.domain.model.user.User;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import com.develop.challenge.bookapi.infrastructure.adapter.external.delegate.UserDelegateClient;
import com.develop.challenge.bookapi.infrastructure.adapter.external.mapper.UserExternalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserExternalAdapter implements UserExternalPort {

    private final UserDelegateClient userDelegateClient;
    private final UserExternalMapper userExternalMapper;

    @Override
    public List<User> findAll() {
        return userExternalMapper.dtoToDomainList(userDelegateClient.findAll());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDelegateClient.findByEmail(email).map(userExternalMapper::dtoToDomain);
    }

    @Override
    public List<User> findByUserIdList(List<Long> userIds) {
        return userExternalMapper.dtoToDomainList(
                userDelegateClient.findAll().stream()
                        .filter(userExternalDto -> userIds.contains(userExternalDto.getId()))
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<User> findById(long id) {
        return userDelegateClient.findById(id).map(userExternalMapper::dtoToDomain);
    }
}
