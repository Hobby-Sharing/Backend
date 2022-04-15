package com.hobby.sharing.domain.hobby.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class HobbyNotFoundException extends GlobalException {

    public static final HobbyNotFoundException EXCEPTION = new HobbyNotFoundException();

    private HobbyNotFoundException() {
        super(ErrorCode.HOBBY_NOT_FOUND);
    }
}
