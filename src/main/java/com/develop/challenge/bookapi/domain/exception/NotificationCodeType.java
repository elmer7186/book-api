package com.develop.challenge.bookapi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationCodeType {

    NOT_FOUND_EXTERNAL_USER("BK_XUSR_NF", "External user not found"),
    NOT_FOUND_CREDENTIALS_USER("BK_CUS_NF", "User credentials not found"),
    BOOK_API_UNEXPECTED_EXCEPTION("BK_UN_EX", "Unexpected exception"),
    REQUIRED_VALUE_USER_ID("BK_RV_USID", "Required value user_id"),
    REQUIRED_VALUE_ALBUM_ID("BK_RV_ALID", "Required value album_id"),
    REQUIRED_VALUE_PRIVILEGE("BK_RV_PRV", "Required value privilege"),
    ALBUM_OWNER_DOES_NOT_MATCH("BK_ALB_NOWN", "User does not own the album");

    private String code;
    private String message;

}
