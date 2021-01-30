package com.develop.challenge.bookapi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationCodeType {

    NOT_FOUND_EXTERNAL_USER("BK_XUSR_NF", "External user not found"),
    NOT_FOUND_CREDENTIALS_USER("BK_CUS_NF", "User credentials not found"),
    BOOK_API_UNEXPECTED_EXCEPTION("BK_UN_EX", "Unexpected exception");

    private String code;
    private String message;

}
