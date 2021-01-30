package com.develop.challenge.bookapi.domain.port.repository;

import com.develop.challenge.bookapi.domain.model.User;

public interface UserRepositoryPort {

    /**
     * Save user
     *
     * @param user domain model
     */
    void save(User user);

    /**
     * Encrypt password and then save user
     *
     * @param user     domain model
     * @param password password
     */
    void encryptPasswordAndSave(User user, String password);
}
