package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.SharedDto;
import com.develop.challenge.bookapi.domain.model.shared.Shared;
import com.develop.challenge.bookapi.domain.service.SharedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SharedAppService {

    private SharedService sharedService;

    public void registerShared(SharedDto sharedDto, long userIdSession) {
        Shared shared = new Shared(sharedDto.getUserId(),
                sharedDto.getAlbumId(), sharedDto.getPrivilegeType());
        sharedService.save(shared, userIdSession);
    }

}
