package com.hobby.sharing.domain.hobby.exception;


import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class LikeHobbyAlreadyExistsException extends BasicException {

    public static final LikeHobbyAlreadyExistsException EXCEPTION = new LikeHobbyAlreadyExistsException();

    private LikeHobbyAlreadyExistsException() {
        super(ErrorCode.LIKE_HOBBY_ALREADY_EXISTS);
    }
}
