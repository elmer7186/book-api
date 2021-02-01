package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.shared.AlbumDto;
import com.develop.challenge.bookapi.application.mapper.AlbumAppMapper;
import com.develop.challenge.bookapi.domain.port.external.AlbumExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AlbumAppService {

    private AlbumExternalPort albumExternalPort;
    private AlbumAppMapper albumAppMapper;

    public List<AlbumDto> findAll() {
        return albumAppMapper.domainToDtoList(albumExternalPort.findAll());
    }

    public List<AlbumDto> findByUserId(long userId) {
        return albumAppMapper.domainToDtoList(albumExternalPort.findByUserId(userId));
    }

}
