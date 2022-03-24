package com.hobby.sharing.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    EXPIRED_TOKEN(401, "AUTH-401-1", "Expired Token"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found");

    private final int status;
    private final String code;
    private final String message;
}