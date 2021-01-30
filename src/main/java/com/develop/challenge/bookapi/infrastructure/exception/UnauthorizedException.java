package com.develop.challenge.bookapi.infrastructure.exception;

public class UnauthorizedException extends TechnicalException {

    public UnauthorizedException(TechnicalNotificationCodeType technicalNotificationCode) {
        super(technicalNotificationCode.getMessage(), technicalNotificationCode);
    }
}
