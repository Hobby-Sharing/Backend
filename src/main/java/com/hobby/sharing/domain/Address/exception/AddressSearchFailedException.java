package com.hobby.sharing.domain.Address.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.GlobalException;

public class AddressSearchFailedException extends GlobalException {

    public static final AddressSearchFailedException EXCEPTION = new AddressSearchFailedException();

    private AddressSearchFailedException() {
        super(ErrorCode.ADDRESS_SEARCH_FAILED);
    }
}
