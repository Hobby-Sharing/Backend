package com.hobby.sharing.domain.Address.exception;

import com.hobby.sharing.global.error.ErrorCode;
import com.hobby.sharing.global.error.exception.BasicException;

public class AddressSearchFailedException extends BasicException {

    public static final AddressSearchFailedException EXCEPTION = new AddressSearchFailedException();

    private AddressSearchFailedException() {
        super(ErrorCode.ADDRESS_SEARCH_FAILED);
    }
}
