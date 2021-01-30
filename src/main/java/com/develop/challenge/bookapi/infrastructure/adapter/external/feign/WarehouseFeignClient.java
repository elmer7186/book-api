package com.develop.challenge.bookapi.infrastructure.adapter.external.feign;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.user.UserExternalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
        name = "${feign.warehouse.name}", url = "${feign.warehouse.rootUrl}"
)
public interface WarehouseFeignClient {

    /**
     * Find all users from external service
     *
     * @return users list
     */
    @GetMapping(
            value = "${feign.warehouse.resources.users}", produces = APPLICATION_JSON_VALUE
    )
    List<UserExternalDto> findAllUsers();

    /**
     * Find all users from external service
     *
     * @return users list
     */
    @GetMapping(
            value = "${feign.warehouse.resources.users}",
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE
    )
    List<UserExternalDto> findUsersByEmail(@RequestParam String email);

}
