package com.hobby.sharing.global.error.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.response.BasicErrorResponse;
import lombok.Getter;

@Getter
public class BasicException extends RuntimeException implements GlobalException<BasicErrorResponse> {

    private final BasicErrorResponse errorResponse;

    protected BasicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorResponse = new BasicErrorResponse(errorCode);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
