package com.hobby.sharing.domain.club.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class ClubMemberNotFoundException extends GlobalException {

    public static final ClubMemberNotFoundException EXCEPTION = new ClubMemberNotFoundException();

    private ClubMemberNotFoundException() {
        super(ErrorCode.CLUB_MEMBER_NOT_FOUND);
    }
}
