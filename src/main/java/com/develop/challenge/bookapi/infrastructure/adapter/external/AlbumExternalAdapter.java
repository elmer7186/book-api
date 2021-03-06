package com.develop.challenge.bookapi.infrastructure.adapter.external;

import com.develop.challenge.bookapi.domain.model.shared.Album;
import com.develop.challenge.bookapi.domain.port.external.AlbumExternalPort;
import com.develop.challenge.bookapi.infrastructure.adapter.external.delegate.AlbumDelegateClient;
import com.develop.challenge.bookapi.infrastructure.adapter.external.mapper.AlbumExternalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class AlbumExternalAdapter implements AlbumExternalPort {

    private AlbumDelegateClient albumDelegateClient;
    private AlbumExternalMapper albumExternalMapper;

    @Override
    public Optional<Album> findByIdAndUserId(long id, long userId) {
        return albumDelegateClient.findByIdAndUserId(id, userId)
                .map(albumExternalMapper::dtoToDomain);
    }

    @Override
    public List<Album> findAll() {
        return albumExternalMapper.dtoToDomainList(albumDelegateClient.findAll());
    }

    @Override
    public List<Album> findByUserId(long userId) {
        return albumExternalMapper.dtoToDomainList(albumDelegateClient.findByUserId(userId));
    }
}
