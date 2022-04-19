package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubApplyNotFoundException extends GlobalException {
    public static final ClubApplyNotFoundException EXCEPTION = new ClubApplyNotFoundException();

    private ClubApplyNotFoundException() {
        super(ErrorCode.CLUB_APPLY_NOT_FOUND);
    }
}