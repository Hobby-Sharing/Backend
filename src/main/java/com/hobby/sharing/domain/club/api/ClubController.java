package com.hobby.sharing.domain.club.api;

import com.hobby.sharing.domain.club.application.ClubListService;
import com.hobby.sharing.domain.club.application.CreateClubService;
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest;
import com.hobby.sharing.domain.club.dto.response.ClubListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClubController {

    private final ClubListService clubListService;
    private final CreateClubService createClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/club") @PreAuthorize("isAuthenticated()")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.execute(request);
    }

    @GetMapping("/club") @PreAuthorize("isAuthenticated()")
    public List<ClubListResponse> getClubList() {
        return clubListService.execute();
    }
}