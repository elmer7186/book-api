package com.develop.challenge.bookapi.domain.port.external;

import com.develop.challenge.bookapi.domain.model.photo.Photo;

import java.util.List;

public interface PhotoExternalPort {

    /**
     * Find all photos from external service
     *
     * @return domain model list
     */
    List<Photo> findAll();

}
