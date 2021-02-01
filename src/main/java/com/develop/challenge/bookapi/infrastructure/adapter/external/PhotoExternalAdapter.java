package com.develop.challenge.bookapi.infrastructure.adapter.external;

import com.develop.challenge.bookapi.domain.model.photo.Photo;
import com.develop.challenge.bookapi.domain.port.external.PhotoExternalPort;
import com.develop.challenge.bookapi.infrastructure.adapter.external.delegate.PhotoDelegateClient;
import com.develop.challenge.bookapi.infrastructure.adapter.external.mapper.PhotoExternalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PhotoExternalAdapter implements PhotoExternalPort {

    private final PhotoExternalMapper photoExternalMapper;
    private final PhotoDelegateClient photoDelegateClient;

    @Override
    public List<Photo> findAll() {
        return photoExternalMapper.dtoToDomainList(photoDelegateClient.findAll());
    }

    @Override
    public List<Photo> findByAnyAlbumId(List<Long> albumIds) {
        return photoExternalMapper.dtoToDomainList(
                photoDelegateClient.findAll()
                        .stream()
                        .filter(photoExternalDto -> albumIds.contains(photoExternalDto.getAlbumId()))
                        .collect(Collectors.toList()));
    }
}
