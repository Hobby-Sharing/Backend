package com.hobby.sharing.global.error.response;

import com.hobby.sharing.global.error.ErrorCode;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class BasicErrorResponse {

    // jackson 어노테이션을 통해 json 순서 정렬 필요 (이후에 커밋)
    private final ZonedDateTime zonedDateTime;

    private final int status;

    private final String code;

    private final String message;

    public BasicErrorResponse(ErrorCode errorCode) {
        this.zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}