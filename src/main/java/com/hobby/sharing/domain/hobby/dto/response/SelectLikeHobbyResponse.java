package com.hobby.sharing.domain.hobby.dto.response;

import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SelectLikeHobbyResponse {
    private UUID hobbyId;
    private String hobbyName;
    private String categoryName;

    public static SelectLikeHobbyResponse from(LikeHobby likeHobby) {
        return new SelectLikeHobbyResponse(likeHobby.getHobby().getId(), likeHobby.getHobby().getName(), likeHobby.getHobby().getCategory().getName());
    }
}
