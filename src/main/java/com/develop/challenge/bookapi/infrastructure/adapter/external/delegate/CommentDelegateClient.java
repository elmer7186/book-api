package com.develop.challenge.bookapi.infrastructure.adapter.external.delegate;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.comment.CommentExternalDto;
import com.develop.challenge.bookapi.infrastructure.adapter.external.feign.WarehouseFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CommentDelegateClient {

    private final WarehouseFeignClient warehouseFeignClient;

    public List<CommentExternalDto> findAll() {
        return warehouseFeignClient.findAllComments();
    }

}
