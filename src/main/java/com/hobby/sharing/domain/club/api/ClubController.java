package com.hobby.sharing.domain.club.api;

import com.hobby.sharing.domain.club.application.CreateClubService;
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ClubController {

    private final CreateClubService createClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/club") @PreAuthorize("isAuthenticated()")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.execute(request);
    }
}