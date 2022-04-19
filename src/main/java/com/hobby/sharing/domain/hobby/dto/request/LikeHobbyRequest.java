package com.hobby.sharing.domain.hobby.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeHobbyRequest {
    private String hobbyId;
}
