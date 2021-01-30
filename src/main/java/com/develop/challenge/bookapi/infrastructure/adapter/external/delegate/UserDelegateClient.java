package com.develop.challenge.bookapi.infrastructure.adapter.external.delegate;

import com.develop.challenge.bookapi.infrastructure.adapter.external.dto.user.UserExternalDto;
import com.develop.challenge.bookapi.infrastructure.adapter.external.feign.WarehouseFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDelegateClient {

    private WarehouseFeignClient warehouseFeignClient;

    public List<UserExternalDto> findAll() {
        return warehouseFeignClient.findAllUsers();
    }

    public Optional<UserExternalDto> findByEmail(String email) {
        return warehouseFeignClient.findUsersByEmail(email).stream().findFirst();
    }

}
