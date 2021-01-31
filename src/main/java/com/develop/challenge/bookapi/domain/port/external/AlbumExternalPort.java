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
     * @return optional album value
     */
    Optional<Album> findByIdAndUserId(long id, long userId);

    /**
     * Find all albums from external service
     *
     * @return album list
     */
    List<Album> findAll();

}
