package com.hobby.sharing.domain.hobby.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeHobbyRequest {
    private UUID hobbyId;
}
