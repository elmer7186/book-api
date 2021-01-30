package com.develop.challenge.bookapi.domain.port.external;

import com.develop.challenge.bookapi.domain.model.shared.Album;

import java.util.Optional;

public interface AlbumExternalPort {

    Optional<Album> findByIdAndUserId(long id, long userId);

}
