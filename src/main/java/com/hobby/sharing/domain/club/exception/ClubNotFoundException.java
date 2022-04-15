package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubNotFoundException extends GlobalException {

    public static final ClubNotFoundException EXCEPTION = new ClubNotFoundException();

    private ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}