package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubAlreadyExistsException extends GlobalException {

    public static final ClubAlreadyExistsException EXCEPTION = new ClubAlreadyExistsException();

    private ClubAlreadyExistsException() {
        super(ErrorCode.CLUB_ALREADY_EXISTS);
    }
}
