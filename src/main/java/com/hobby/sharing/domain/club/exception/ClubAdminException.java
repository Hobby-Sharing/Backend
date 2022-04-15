package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class ClubAdminException extends BasicException {

    public static final ClubAdminException EXCEPTION = new ClubAdminException();

    private ClubAdminException() {
        super(ErrorCode.NOT_CLUB_ADMIN);
    }

}