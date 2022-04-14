package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class ClubMemberAlreadyExistsException extends BasicException {

    public static final ClubMemberAlreadyExistsException EXCEPTION = new ClubMemberAlreadyExistsException();

    private ClubMemberAlreadyExistsException() {
        super(ErrorCode.CLUB_MEMBER_ALREADY_EXISTS);
    }
}
