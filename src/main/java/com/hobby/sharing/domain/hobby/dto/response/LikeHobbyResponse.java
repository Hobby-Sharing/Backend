package com.hobby.sharing.domain.hobby.dto.response;

import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class LikeHobbyResponse {
    private UUID hobbyId;
    private String hobbyName;
    private String categoryName;
}
