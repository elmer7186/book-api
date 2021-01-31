package com.develop.challenge.bookapi.domain.port.external;

import com.develop.challenge.bookapi.domain.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserExternalPort {

    /**
     * Find all users from external service
     *
     * @return domain user list
     */
    List<User> findAll();

    /**
     * Find user by email
     *
     * @param email user email
     * @return user optional value
     */
    Optional<User> findByEmail(String email);

}
