package com.develop.challenge.bookapi.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TechnicalNotificationCodeType {

    ACCESS_DENIED("BK_ACC_DEN", "Access denied");

    private String code;
    private String message;

}
