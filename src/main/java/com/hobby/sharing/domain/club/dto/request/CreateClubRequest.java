package com.hobby.sharing.domain.club.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateClubRequest {

    private String hobbyId;

    @NotBlank
    private String name;
    
    private String introMessage;
}