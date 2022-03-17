package com.hobby.sharing.global.error.response;

import com.hobby.sharing.global.error.ErrorCode;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class BusinessErrorResponse {

    private final ZonedDateTime zonedDateTime;

    private final int status;

    private final String code;

    private final String message;

    public BusinessErrorResponse(ErrorCode errorCode) {
        this.zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}