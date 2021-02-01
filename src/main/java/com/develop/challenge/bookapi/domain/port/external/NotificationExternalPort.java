package com.develop.challenge.bookapi.domain.port.external;

public interface NotificationExternalPort {

    /**
     * Send email method
     *
     * @param email recipient
     * @param otp   temporal one time password
     */
    void sendOtpEmail(String email, String otp);

}
