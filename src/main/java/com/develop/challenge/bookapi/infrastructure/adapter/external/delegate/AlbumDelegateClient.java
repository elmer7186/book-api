package com.develop.challenge.bookapi.infrastructure.adapter.external.delegate;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.album.AlbumExternalDto;
import com.develop.challenge.bookapi.infrastructure.adapter.external.feign.WarehouseFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class AlbumDelegateClient {

    private WarehouseFeignClient warehouseFeignClient;

    public Optional<AlbumExternalDto> findByIdAndUserId(long id, long userId) {
        return warehouseFeignClient.findAlbumsByIdAndUserId(id, userId).stream().findFirst();
    }

    public List<AlbumExternalDto> findAll() {
        return warehouseFeignClient.findAllAlbums();
    }

    public List<AlbumExternalDto> findByUserId(long userId) {
        return warehouseFeignClient.findAlbumsByUserId(userId);
    }

}
