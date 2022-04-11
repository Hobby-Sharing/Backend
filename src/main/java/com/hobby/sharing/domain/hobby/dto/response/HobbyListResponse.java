package com.hobby.sharing.domain.hobby.dto.response;

import com.hobby.sharing.domain.hobby.domain.Hobby;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class HobbyListResponse {
    private UUID hobbyId;
    private String name;
    private String categoryName;

    public static HobbyListResponse from(Hobby hobby) {
        return new HobbyListResponse(hobby.getId(), hobby.getName(), hobby.getCategory().getName());
    }
}
