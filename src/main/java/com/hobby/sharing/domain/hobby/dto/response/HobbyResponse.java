package com.hobby.sharing.domain.hobby.dto.response;

import com.hobby.sharing.domain.hobby.domain.Hobby;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HobbyResponse {
    private String id;
    private String hobbyName;
    private String categoryName;

    public static HobbyResponse from(Hobby hobby) {
        return new HobbyResponse(hobby.getId().toString(), hobby.getName(), hobby.getCategory().getName());
    }
}