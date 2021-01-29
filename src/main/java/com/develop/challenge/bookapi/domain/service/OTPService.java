package com.develop.challenge.bookapi.domain.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    public static final int OTP_LENGTH = 6;

    public String generate() {
        return RandomStringUtils.random(OTP_LENGTH);
    }

}
