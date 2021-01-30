package com.develop.challenge.bookapi.infrastructure.adapter.external.mapper;

import com.develop.challenge.bookapi.domain.model.shared.Album;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.album.AlbumExternalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AlbumExternalMapper {

    /**
     * Mapper for album external Dto to domain model
     *
     * @param albumExternalDto dto object
     * @return domain model
     */
    Album dtoToDomain(AlbumExternalDto albumExternalDto);

}
