package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class ClubDetailNotFoundException extends BasicException {
    public static final ClubDetailNotFoundException EXCEPTION = new ClubDetailNotFoundException();

    private ClubDetailNotFoundException() {
        super(ErrorCode.CLUB_DETAIL_NOT_FOUND);
    }
}
