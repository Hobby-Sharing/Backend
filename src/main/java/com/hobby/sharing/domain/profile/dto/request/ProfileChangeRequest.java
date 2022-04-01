package com.hobby.sharing.domain.profile.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileChangeRequest {
    private String profileImageUrl;
    private String statusMessage;
}
