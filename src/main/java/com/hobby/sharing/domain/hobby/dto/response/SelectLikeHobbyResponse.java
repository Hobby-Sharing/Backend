package com.hobby.sharing.domain.hobby.dto.response;

import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SelectLikeHobbyResponse {
    private Long likeHobbyId;
    private UUID hobbyId;

    public static SelectLikeHobbyResponse from(LikeHobby likeHobby) {
        return new SelectLikeHobbyResponse(likeHobby.getId(), likeHobby.getHobby().getId());
    }
}
