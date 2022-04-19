package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubApplyAlreadyExistsException extends GlobalException {

    public static final ClubApplyAlreadyExistsException EXCEPTION = new ClubApplyAlreadyExistsException();

    private ClubApplyAlreadyExistsException() {
        super(ErrorCode.CLUB_APPLY_ALREADY_EXISTS);
    }
}