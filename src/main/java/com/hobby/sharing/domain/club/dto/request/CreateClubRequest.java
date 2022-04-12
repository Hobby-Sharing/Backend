package com.hobby.sharing.domain.club.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateClubRequest {

    private UUID hobbyId;

    @NotBlank
    private String name;

    private String introMessage;
}