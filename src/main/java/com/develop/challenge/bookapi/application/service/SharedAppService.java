package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.shared.SharedDto;
import com.develop.challenge.bookapi.application.dto.user.UserDto;
import com.develop.challenge.bookapi.application.mapper.UserAppMapper;
import com.develop.challenge.bookapi.domain.model.shared.Shared;
import com.develop.challenge.bookapi.domain.port.SharedRepositoryPort;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import com.develop.challenge.bookapi.domain.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class SharedAppService {

    private UserAppMapper userAppMapper;
    private SharedRepositoryPort sharedRepositoryPort;
    private AlbumService albumService;
    private UserExternalPort userExternalPort;

    public void registerShared(SharedDto sharedDto, long userIdSession) {
        albumService.findAlbumByIdAndOwner(sharedDto.getAlbumId(), userIdSession);
        Shared shared = new Shared(sharedDto.getUserId(),
                sharedDto.getAlbumId(), sharedDto.getPrivilegeType());
        sharedRepositoryPort.save(shared);
    }

    public List<UserDto> findUsersByAlbumId(long albumId, long userSessionId) {
        albumService.findAlbumByIdAndOwner(userSessionId, userSessionId);
        List<Long> userIds = sharedRepositoryPort.findByAlbumId(albumId).stream()
                .map(Shared::getUserId)
                .collect(Collectors.toList());
        return userAppMapper.domainToDtoList(userExternalPort.findByUserIdList(userIds));
    }
}
