package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubApplylNotFoundException extends GlobalException {
    public static final ClubApplylNotFoundException EXCEPTION = new ClubApplylNotFoundException();

    private ClubApplylNotFoundException() {
        super(ErrorCode.CLUB_APPLY_NOT_FOUND);
    }
}
