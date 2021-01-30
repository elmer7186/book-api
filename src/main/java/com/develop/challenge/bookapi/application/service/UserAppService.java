package com.develop.challenge.bookapi.application.service;

import com.develop.challenge.bookapi.application.dto.PasswordResetDto;
import com.develop.challenge.bookapi.application.dto.UserActivationDto;
import com.develop.challenge.bookapi.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserAppService {

    private final UserService userService;

    public void requestActivation(UserActivationDto userActivationDto) {
        userService.requestActivation(userActivationDto.getEmail());
    }

    public void changePassword(PasswordResetDto passwordResetDto) {
        userService.changePassword(passwordResetDto.getUsername(),
                passwordResetDto.getOldPassword(), passwordResetDto.getNewPassword());
    }

}
