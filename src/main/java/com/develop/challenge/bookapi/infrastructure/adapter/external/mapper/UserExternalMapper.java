package com.develop.challenge.bookapi.infrastructure.adapter.external.mapper;

import com.develop.challenge.bookapi.domain.model.user.User;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.user.UserExternalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserExternalMapper {

    /**
     * Mapping user external dto list to domain model
     *
     * @param userExternalDtoList external objects
     * @return domain models
     */
    List<User> dtoToDomainList(List<UserExternalDto> userExternalDtoList);

    /**
     * Mapping user external dto to domain model
     *
     * @param userExternalDto external object
     * @return domain model
     */
    User dtoToDomain(UserExternalDto userExternalDto);

}
