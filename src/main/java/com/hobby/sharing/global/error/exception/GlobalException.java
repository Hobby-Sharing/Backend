package com.hobby.sharing.global.error.exception;

public interface GlobalException<ResponseType> {

    ResponseType errorResponse();

}
