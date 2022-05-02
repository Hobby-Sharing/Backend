package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.club.dto.request.ClubRequest;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteClubMemberService {

    private final AuthFacade authFacade;
    private final ClubFacade clubFacade;

    private final ClubMemberRepository clubMemberRepository;

    public void execute(ClubRequest request) {
        checkClubAdmin(request.getClubId());

        ClubEmbed clubEmbed = new ClubEmbed(request.getUserId(), request.getClubId());
        clubFacade.checkClubMemberExists(clubEmbed);
        clubMemberRepository.deleteById(clubEmbed);
    }

    private void checkClubAdmin(Long clubId) {
        Long myId = authFacade.getUser().getId();
        clubFacade.checkClubAdminByUserId(myId, clubId);
    }
}
