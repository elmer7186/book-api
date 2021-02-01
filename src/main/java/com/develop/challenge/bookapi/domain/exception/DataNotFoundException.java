package com.develop.challenge.bookapi.domain.exception;

public class DataNotFoundException extends BusinessException {
    public DataNotFoundException(NotificationCodeType notificationCode) {
        super(notificationCode.getMessage(), notificationCode);
    }
}
