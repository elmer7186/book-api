package com.develop.challenge.bookapi.infrastructure.adapter.external.delegate;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.photo.PhotoExternalDto;
import com.develop.challenge.bookapi.infrastructure.adapter.external.feign.WarehouseFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PhotoDelegateClient {

    private WarehouseFeignClient warehouseFeignClient;

    public List<PhotoExternalDto> findAll() {
        return warehouseFeignClient.findAllPhotos();
    }

}
