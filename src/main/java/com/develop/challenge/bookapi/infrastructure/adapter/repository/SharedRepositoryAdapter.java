package com.develop.challenge.bookapi.infrastructure.adapter.repository;

import com.develop.challenge.bookapi.domain.model.shared.Shared;
import com.develop.challenge.bookapi.domain.port.SharedRepositoryPort;
import com.develop.challenge.bookapi.infrastructure.adapter.repository.jpa.SharedJpaRepository;
import com.develop.challenge.bookapi.infrastructure.adapter.repository.mapper.SharedRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SharedRepositoryAdapter implements SharedRepositoryPort {

    private SharedJpaRepository sharedJpaRepository;
    private SharedRepositoryMapper sharedRepositoryMapper;

    @Override
    public void save(Shared shared) {
        sharedJpaRepository.save(sharedRepositoryMapper.domainToEntity(shared));
    }

    @Override
    public List<Shared> findByAlbumId(long albumId) {
        return sharedRepositoryMapper
                .entityToDomainList(sharedJpaRepository.findByAlbumId(albumId));
    }

}
