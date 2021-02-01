package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.user.PasswordResetDto;
import com.develop.challenge.bookapi.application.dto.user.UserActivationDto;
import com.develop.challenge.bookapi.application.dto.user.UserDto;
import com.develop.challenge.bookapi.application.mapper.UserAppMapper;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import com.develop.challenge.bookapi.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserAppService {

    private final UserService userService;
    private final UserExternalPort userExternalPort;
    private final UserAppMapper userAppMapper;

    public void requestActivation(UserActivationDto userActivationDto) {
        userService.requestActivation(userActivationDto.getEmail());
    }

    public void changePassword(PasswordResetDto passwordResetDto) {
        userService.changePassword(passwordResetDto.getUsername(),
                passwordResetDto.getOldPassword(), passwordResetDto.getNewPassword());
    }

    public List<UserDto> findAll() {
        return userAppMapper.domainToDtoList(userExternalPort.findAll());
    }

}
