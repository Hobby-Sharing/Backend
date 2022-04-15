package com.hobby.sharing.domain.club.api;

import com.hobby.sharing.domain.club.application.*;
import com.hobby.sharing.domain.club.dto.request.ClubRequest;
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

    private final JoinClubService joinClubService;
    private final ClubListService clubListService;
    private final CreateClubService createClubService;
    private final ClubApplyService clubApplyService;
    private final DeleteClubApplyService deleteClubApplyService;
    private final DeleteClubMemberService deleteClubMemberService;


    @GetMapping("/club") @PreAuthorize("isAuthenticated()")
    public List<ClubListResponse> getClubList() {
        return clubListService.execute();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/club") @PreAuthorize("isAuthenticated()")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/club/join-apply/{club_id}") @PreAuthorize("isAuthenticated()")
    public void joinClubApply(@PathVariable(name = "club_id") Long clubId) {
        clubApplyService.execute(clubId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/club/join-apply") @PreAuthorize("isAuthenticated()")
    public void deleteClubJoinApply(@RequestBody @Valid ClubRequest request) {
        deleteClubApplyService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/club/join") @PreAuthorize("isAuthenticated()")
    public void clubJoinAccept(@RequestBody @Valid ClubRequest request) {
        joinClubService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/club/join") @PreAuthorize("isAuthenticated()")
    public void deleteClubMember(@RequestBody @Valid ClubRequest request) {
        deleteClubMemberService.execute(request);
    }
}