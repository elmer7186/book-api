package com.develop.challenge.bookapi.domain.port;

import com.develop.challenge.bookapi.domain.model.shared.Shared;

import java.util.List;

public interface SharedRepositoryPort {

    /**
     * Method to save shared in data repository
     *
     * @param shared domain model
     */
    void save(Shared shared);

    /**
     * Find shared by album id
     *
     * @param albumId album id value
     * @return domain model list
     */
    List<Shared> findByAlbumId(long albumId);

}
