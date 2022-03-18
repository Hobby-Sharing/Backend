package com.hobby.sharing.global.error.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.response.BusinessErrorResponse;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException implements GlobalException<BusinessErrorResponse> {

    private final BusinessErrorResponse errorResponse;

    protected BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorResponse = new BusinessErrorResponse(errorCode);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
