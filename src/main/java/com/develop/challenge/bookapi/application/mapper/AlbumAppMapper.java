package com.develop.challenge.bookapi.application.mapper;

import com.develop.challenge.bookapi.application.dto.shared.AlbumDto;
import com.develop.challenge.bookapi.domain.model.shared.Album;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AlbumAppMapper {

    /**
     * Album mapper domain to Dto objects list
     *
     * @param albums domain model list
     * @return object Dto list
     */
    List<AlbumDto> domainToDtoList(List<Album> albums);

}
