package com.hobby.sharing.domain.profile.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileDetailsInfoResponse {
    private String email;
    private String name;
    private String profileImageUrl;
    private String statusMessage;
    private int zipCode;
    private String roadNameAddress;
}
