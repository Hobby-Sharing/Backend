package com.hobby.sharing.domain.hobby.exception;


import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class LikeHobbyAlreadyExistsException extends GlobalException {

    public static final LikeHobbyAlreadyExistsException EXCEPTION = new LikeHobbyAlreadyExistsException();

    private LikeHobbyAlreadyExistsException() {
        super(ErrorCode.LIKE_HOBBY_ALREADY_EXISTS);
    }
}
