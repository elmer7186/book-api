package com.develop.challenge.bookapi.domain.service;

import com.develop.challenge.bookapi.domain.exception.DataNotFoundException;
import com.develop.challenge.bookapi.domain.port.external.NotificationExternalPort;
import com.develop.challenge.bookapi.domain.port.external.UserExternalPort;
import com.develop.challenge.bookapi.domain.port.repository.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserExternalPort userExternalPort;
    private final UserRepositoryPort userRepositoryPort;
    private final OTPService otpService;
    private final NotificationExternalPort notificationExternalPort;

    public void requestActivation(String email) {
        userExternalPort.findByEmail(email).map(user -> {
            String temporalPassword = otpService.generate();
            user.setEnable(true);
            userRepositoryPort.encryptPasswordAndSave(user, temporalPassword);
            notificationExternalPort.sendOtpEmail(email, temporalPassword);
            return user;
        }).orElseThrow(() -> new DataNotFoundException(""));
    }

}
