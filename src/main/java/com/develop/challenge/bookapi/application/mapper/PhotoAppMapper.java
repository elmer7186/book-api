package com.develop.challenge.bookapi.application.mapper;

import com.develop.challenge.bookapi.application.dto.photo.PhotoDto;
import com.develop.challenge.bookapi.domain.model.photo.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PhotoAppMapper {

    /**
     * Photo mapper domain to DTO objects
     *
     * @param photos domain list
     * @return DTO objects list
     */
    List<PhotoDto> domainToDtoList(List<Photo> photos);

}
