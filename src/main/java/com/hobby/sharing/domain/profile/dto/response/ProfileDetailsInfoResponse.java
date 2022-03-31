package com.hobby.sharing.domain.profile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileDetailsInfoResponse {
    private String email;
    private String name;
    private String profileImageUrl;
    private String statusMessage;
    private int zipCode;
    private String roadNameAddress;
}
