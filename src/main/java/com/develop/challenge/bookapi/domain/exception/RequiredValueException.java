package com.develop.challenge.bookapi.domain.exception;

public class RequiredValueException extends BusinessException {
    public RequiredValueException(NotificationCodeType notificationCode) {
        super(notificationCode.getMessage(), notificationCode);
    }
}
