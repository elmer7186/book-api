package com.develop.challenge.bookapi.infrastructure.adapter.external.mapper;

import com.develop.challenge.bookapi.domain.model.photo.Photo;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.photo.PhotoExternalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PhotoExternalMapper {

    /**
     * Photo mapper dto to domain model list
     *
     * @param photoExternalDtos photo external dto object list
     * @return domain model list
     */
    List<Photo> dtoToDomainList(List<PhotoExternalDto> photoExternalDtos);

}
