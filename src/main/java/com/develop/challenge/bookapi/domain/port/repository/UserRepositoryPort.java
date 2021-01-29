package com.develop.challenge.bookapi.domain.port.repository;

import com.develop.challenge.bookapi.domain.model.User;

public interface UserRepositoryPort {

    void save(User user);

}
