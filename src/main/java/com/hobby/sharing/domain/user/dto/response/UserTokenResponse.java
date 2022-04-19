package com.hobby.sharing.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserTokenResponse {
    private final String accessToken;
    private final String refreshToken;
}
