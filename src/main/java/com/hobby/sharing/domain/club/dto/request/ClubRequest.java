package com.hobby.sharing.domain.club.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long clubId;
}
