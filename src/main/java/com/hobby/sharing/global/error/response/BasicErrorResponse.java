package com.hobby.sharing.global.error.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hobby.sharing.global.error.ErrorCode;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@JsonPropertyOrder({"status", "code", "message", "timestamp"})
public class BasicErrorResponse {

    @JsonProperty("status")
    private final int status;

    @JsonProperty("code")
    private final String code;

    @JsonProperty("message")
    private final String message;

    @JsonProperty("timestamp")
    private final ZonedDateTime zonedDateTime;

    public BasicErrorResponse(ErrorCode errorCode) {
        this.zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}