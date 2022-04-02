package com.hobby.sharing.domain.profile.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class ProfileAlreadyExistsException extends BasicException {

    public static final ProfileAlreadyExistsException EXCEPTION = new ProfileAlreadyExistsException();

    private ProfileAlreadyExistsException() {
        super(ErrorCode.PROFILE_ALREADY_EXISTS);
    }
}
