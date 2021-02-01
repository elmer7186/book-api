package com.develop.challenge.bookapi.application.mapper;

import com.develop.challenge.bookapi.application.dto.comment.CommentDto;
import com.develop.challenge.bookapi.domain.model.comment.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentAppMapper {

    /**
     * Comment mapper domain to dto list
     *
     * @param comments domain model list
     * @return dto objects list
     */
    List<CommentDto> domainToDtoList(List<Comment> comments);

}
