package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubDetailAlreadyExistsException extends GlobalException {

    public static final ClubDetailAlreadyExistsException EXCEPTION = new ClubDetailAlreadyExistsException();

    private ClubDetailAlreadyExistsException() {
        super(ErrorCode.CLUB_DETAIL_ALREADY_EXISTS);
    }
}
