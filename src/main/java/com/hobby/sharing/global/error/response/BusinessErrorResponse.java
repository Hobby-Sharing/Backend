package com.hobby.sharing.global.error.response;

import com.hobby.sharing.global.error.ErrorCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BusinessErrorResponse {

    private final LocalDateTime localDateTime;

    private final int status;

    private final String code;

    private final String message;

    public BusinessErrorResponse(ErrorCode errorCode) {
        this.localDateTime = LocalDateTime.now();
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}

}
