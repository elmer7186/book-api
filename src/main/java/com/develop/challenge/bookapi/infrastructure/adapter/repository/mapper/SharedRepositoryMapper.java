package com.develop.challenge.bookapi.infrastructure.adapter.repository.mapper;

import com.develop.challenge.bookapi.domain.model.shared.Shared;
import com.develop.challenge.bookapi.infrastructure.adapter.repository.entity.SharedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SharedRepositoryMapper {

    /**
     * Shared map entity to domain
     *
     * @param sharedEntity shared entity object
     * @return domain model
     */
    Shared entityToDomain(SharedEntity sharedEntity);

    /**
     * Shared map domain to entity
     *
     * @param shared shared domain model
     * @return entity object
     */
    SharedEntity domainToEntity(Shared shared);

    /**
     * Shared map entities to domain list
     *
     * @param sharedEntities shared entity object list
     * @return domain model list
     */
    List<Shared> entityToDomainList(List<SharedEntity> sharedEntities);

}
