package com.develop.challenge.bookapi.infrastructure.adapter.external.mapper;

import com.develop.challenge.bookapi.domain.model.shared.Album;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.album.AlbumExternalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AlbumExternalMapper {

    /**
     * Mapper for album external Dto to domain model
     *
     * @param albumExternalDto dto object
     * @return domain model
     */
    Album dtoToDomain(AlbumExternalDto albumExternalDto);

    /**
     * Mapper for album external Dto to domain model list
     *
     * @param albumExternalDtos dto object list
     * @return domain model list
     */
    List<Album> dtoToDomainList(List<AlbumExternalDto> albumExternalDtos);

}
