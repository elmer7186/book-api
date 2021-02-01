package com.develop.challenge.bookapi.application.mapper;

import com.develop.challenge.bookapi.application.dto.user.UserDto;
import com.develop.challenge.bookapi.domain.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserAppMapper {

    /**
     * User mapper domain to Dto list
     *
     * @param users domain model list
     * @return object Dto list
     */
    List<UserDto> domainToDtoList(List<User> users);

}
