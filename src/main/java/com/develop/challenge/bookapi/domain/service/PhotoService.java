package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.model.photo.Photo;
import com.develop.challenge.bookapi.domain.model.shared.Album;
import com.develop.challenge.bookapi.domain.port.external.AlbumExternalPort;
import com.develop.challenge.bookapi.domain.port.external.PhotoExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PhotoService {

    private final PhotoExternalPort photoExternalPort;
    private final AlbumExternalPort albumExternalPort;

    public List<Photo> findByUserId(long userId) {
        List<Long> albumIds = albumExternalPort.findByUserId(userId)
                .stream().map(Album::getUserId).collect(Collectors.toList());
        return photoExternalPort.findByAnyAlbumId(albumIds);
    }

}
