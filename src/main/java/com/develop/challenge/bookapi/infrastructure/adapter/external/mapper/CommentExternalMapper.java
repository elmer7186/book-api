package com.develop.challenge.bookapi.infrastructure.adapter.external.mapper;

import com.develop.challenge.bookapi.domain.model.comment.Comment;
import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.comment.CommentExternalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentExternalMapper {

    /**
     * Comment mapper dto to domain list
     *
     * @param commentExternalDtos external dtos list
     * @return domain model list
     */
    List<Comment> dtoToDomainList(List<CommentExternalDto> commentExternalDtos);

}
