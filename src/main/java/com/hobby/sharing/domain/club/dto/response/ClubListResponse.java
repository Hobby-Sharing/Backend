package com.hobby.sharing.domain.club.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ClubListResponse {
    private UUID hobbyId;
    private String hobbyName;
    private String clubName;
    private String categoryName;
}