package com.hobby.sharing.domain.club.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateClubRequest {

    private String hobbyId;

    @NotBlank
    private String name;
    
    private String introMessage;
}