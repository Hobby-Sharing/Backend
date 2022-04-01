package com.hobby.sharing.domain.profile.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileRegistrationRequest {
    @NotNull
    private String profileImageUrl;
    @NotNull
    private String statusMessage;
}
