package com.hobby.sharing.global.security.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class TokenRefreshException extends BasicException {

    public static final TokenRefreshException EXCEPTION = new TokenRefreshException();

    private TokenRefreshException() {
        super(ErrorCode.TOKEN_REFRESH_FAILED);
    }
}
