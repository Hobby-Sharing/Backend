package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubDetailNotFoundException extends GlobalException {
    public static final ClubDetailNotFoundException EXCEPTION = new ClubDetailNotFoundException();

    private ClubDetailNotFoundException() {
        super(ErrorCode.CLUB_DETAIL_NOT_FOUND);
    }
}
