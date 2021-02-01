package com.develop.challenge.bookapi.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OTPServiceTest {

    private OTPService otpService;

    @BeforeEach
    void setUp() {
        otpService = new OTPService();
    }

    @Test
    void shouldReturnSpecificSizeWhenGenerateOtp() {
        Assertions.assertThat(otpService.generate()).hasSize(OTPService.OTP_LENGTH);
    }
}