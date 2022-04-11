package com.hobby.sharing.domain.hobby.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class HobbyListResponse {
    private UUID id;
    private String name;
    private String categoryName;
}
