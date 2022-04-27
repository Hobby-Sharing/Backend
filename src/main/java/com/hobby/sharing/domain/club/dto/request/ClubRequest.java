package com.hobby.sharing.domain.club.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ClubRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long clubId;
}
