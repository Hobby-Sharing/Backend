package com.hobby.sharing.domain.hobby.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class HobbyNotFoundException extends BasicException {

    public static final HobbyNotFoundException EXCEPTION = new HobbyNotFoundException();

    private HobbyNotFoundException(){
        super(ErrorCode.HOBBY_NOT_FOUND);
    }
}
