package com.develop.challenge.bookapi.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusinessException extends RuntimeException {

    private final NotificationCodeType notificationCode;

    public BusinessException(String message, NotificationCodeType notificationCode) {
        super(message);
        this.notificationCode = notificationCode;
    }

}
