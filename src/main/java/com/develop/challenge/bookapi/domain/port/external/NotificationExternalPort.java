package com.develop.challenge.bookapi.domain.port.external;

public interface NotificationExternalPort {

    /**
     * Send email method
     *
     * @param recipient email recipient
     * @param subject   email subject
     * @param message   email message content
     */
    void sendEmail(String recipient, String subject, String message);

}
