package com.develop.challenge.bookapi.domain.port.external;

import com.develop.challenge.bookapi.domain.model.shared.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumExternalPort {

    /**
     * Search album by id and user id from external service
     *
     * @param id     album id
     * @param userId user id
     * @return domain model list
     */
    Optional<Album> findByIdAndUserId(long id, long userId);

    /**
     * Find all albums from external service
     *
     * @return album list
     */
    List<Album> findAll();

    /**
     * Search album by user id from external service
     *
     * @param userId user id
     * @return domain model list
     */
    List<Album> findByUserId(long userId);
}
