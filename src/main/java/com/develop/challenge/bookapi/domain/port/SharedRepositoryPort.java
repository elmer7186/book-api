package com.develop.challenge.bookapi.domain.port;

import com.develop.challenge.bookapi.domain.model.shared.Shared;

public interface SharedRepositoryPort {

    /**
     * Method to save shared in data repository
     *
     * @param shared domain model
     */
    void save(Shared shared);

}
