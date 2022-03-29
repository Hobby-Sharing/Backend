package com.hobby.sharing.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    EXPIRED_TOKEN(401, "AUTH-401-1", "Expired Token"),
    INVALID_TOKEN(401, "AUTH-401-2", "Invalid Token"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),

    USER_ALREADY_EXISTS(409, "USER-409-1", "This email is already registered."),

    ADDRESS_SEARCH_FAILED(500, "SERVER-500-1", "Address Search Failed");

    private final int status;
    private final String code;
    private final String message;
}