package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.photo.PhotoDto;
import com.develop.challenge.bookapi.application.mapper.PhotoAppMapper;
import com.develop.challenge.bookapi.domain.port.external.PhotoExternalPort;
import com.develop.challenge.bookapi.domain.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PhotoAppService {

    private final PhotoExternalPort photoExternalPort;
    private final PhotoService photoService;
    private final PhotoAppMapper photoAppMapper;

    public List<PhotoDto> findAll() {
        return photoAppMapper.domainToDtoList(photoExternalPort.findAll());
    }

    public List<PhotoDto> findByUserId(long userId) {
        return photoAppMapper.domainToDtoList(photoService.findByUserId(userId));
    }
}
