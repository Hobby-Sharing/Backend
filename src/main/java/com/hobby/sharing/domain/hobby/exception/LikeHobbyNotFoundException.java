package com.hobby.sharing.domain.hobby.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class LikeHobbyNotFoundException extends BasicException {

    public static final LikeHobbyNotFoundException EXCEPTION = new LikeHobbyNotFoundException();

    private LikeHobbyNotFoundException() {
        super(ErrorCode.LIKE_HOBBY_NOT_FOUND);
    }
}
