package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.exception.OperationNotAllowedException;
import com.develop.challenge.bookapi.domain.model.shared.Shared;
import com.develop.challenge.bookapi.domain.port.SharedRepositoryPort;
import com.develop.challenge.bookapi.domain.port.external.AlbumExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.develop.challenge.bookapi.domain.exception.NotificationCodeType.ALBUM_OWNER_DOES_NOT_MATCH;

@AllArgsConstructor
@Service
public class SharedService {

    private SharedRepositoryPort sharedRepositoryPort;
    private AlbumExternalPort albumExternalPort;

    public void save(Shared shared, long userIdSession) {
        if(!albumExternalPort.findByIdAndUserId(shared.getAlbumId(),
                userIdSession).isPresent()){
            throw new OperationNotAllowedException(ALBUM_OWNER_DOES_NOT_MATCH);
        }
        sharedRepositoryPort.save(shared);
    }

}
