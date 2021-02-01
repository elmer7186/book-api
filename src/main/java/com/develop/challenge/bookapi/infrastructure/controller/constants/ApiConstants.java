package com.develop.challenge.bookapi.infrastructure.controller.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ApiConstants {

    public static final String ROOT_API_V1 = "/v1/api";
    public static final String USERS_BASIC_PATH = "/users";

    public static final String USERS_V1 = ROOT_API_V1 + USERS_BASIC_PATH;
    public static final String RESOURCE_USERS_REQUEST_ACTIVE = "/activation";
    public static final String RESOURCE_USERS_CHANGE_PASSWORD = "/password";

    public static final String SHARED_V1 = ROOT_API_V1 + "/shared";
    public static final String PHOTOS_V1 = ROOT_API_V1 + "/photos";
    public static final String ALBUMS_V1 = ROOT_API_V1 + "/albums";
    public static final String RESOURCE_ALBUMS_USER_SESSION = USERS_BASIC_PATH;
    public static final String RESOURCE_PHOTOS_USER_SESSION = USERS_BASIC_PATH;
    public static final String RESOURCE_GET_USERS_SHARED_BY_ALBUMS_ID = "/albums/{albumId}/users";

}
