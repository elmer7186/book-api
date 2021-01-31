package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.photo.PhotoDto;
import com.develop.challenge.bookapi.application.mapper.PhotoAppMapper;
import com.develop.challenge.bookapi.domain.port.external.PhotoExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PhotoAppService {

    private final PhotoExternalPort photoExternalPort;
    private final PhotoAppMapper photoAppMapper;

    public List<PhotoDto> findAll() {
        return photoAppMapper.domainToDtoList(photoExternalPort.findAll());
    }

}
