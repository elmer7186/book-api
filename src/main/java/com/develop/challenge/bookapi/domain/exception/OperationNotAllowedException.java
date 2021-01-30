package com.develop.challenge.bookapi.domain.exception;

public class OperationNotAllowedException extends BusinessException {
    public OperationNotAllowedException(NotificationCodeType notificationCode) {
        super(notificationCode.getMessage(), notificationCode);
    }
}
