package com.develop.challenge.bookapi.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TechnicalException extends RuntimeException {

    private final TechnicalNotificationCodeType technicalNotificationCode;

    public TechnicalException(String message, TechnicalNotificationCodeType technicalNotificationCode) {
        super(message);
        this.technicalNotificationCode = technicalNotificationCode;
    }
}
