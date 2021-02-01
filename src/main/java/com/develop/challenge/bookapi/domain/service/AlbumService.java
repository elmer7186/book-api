package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.exception.OperationNotAllowedException;
import com.develop.challenge.bookapi.domain.model.shared.Album;
import com.develop.challenge.bookapi.domain.port.external.AlbumExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.develop.challenge.bookapi.domain.exception.NotificationCodeType.ALBUM_OWNER_DOES_NOT_MATCH;

@AllArgsConstructor
@Service
public class AlbumService {

    private AlbumExternalPort albumExternalPort;

    public Album findAlbumByIdAndOwner(long albumId, long userId) {
        return albumExternalPort.findByIdAndUserId(albumId, userId)
                .orElseThrow(() -> new OperationNotAllowedException(ALBUM_OWNER_DOES_NOT_MATCH));
    }

}
