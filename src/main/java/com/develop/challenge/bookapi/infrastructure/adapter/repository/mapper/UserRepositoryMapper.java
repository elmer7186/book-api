package com.develop.challenge.bookapi.infrastructure.adapter.repository.mapper;

import com.develop.challenge.bookapi.domain.model.User;
import com.develop.challenge.bookapi.infrastructure.adapter.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRepositoryMapper {

    /**
     * User mapper domain model to entity object
     *
     * @param user Domain model object
     * @return Entity object
     */
    UserEntity domainToEntity(User user);

    /**
     * User mapper entity to domain
     *
     * @param userEntity user entity object
     * @return domain model
     */
    User entityToDomain(UserEntity userEntity);

}
