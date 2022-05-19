package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubApplyRepository;
import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.ClubMember;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.club.domain.role.ClubRole;
import com.hobby.sharing.domain.club.dto.request.ClubRequest;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinClubService {

    private final AuthFacade authFacade;
    private final ClubFacade clubFacade;

    private final ClubRepository clubRepository;
    private final ClubMemberRepository clubMemberRepository;
    private final ClubApplyRepository clubApplyRepository;


    public void execute(ClubRequest request) {
        checkClubAdmin(request.getClubId());
        clubFacade.checkClubApplyExists(request.getUserId(), request.getClubId());
        clubFacade.checkClubMemberNotExists(request.getUserId(), request.getClubId());

        User user = authFacade.getUser();
        Club club = clubFacade.getClubById(request.getClubId());

        ClubMember clubMember = ClubMember.builder()
                .user(user)
                .club(club)
                .role(ClubRole.USER)
                .build();
        clubMemberRepository.save(clubMember);

        deleteClubApply(user.getId(), club.getId());
    }

    private void deleteClubApply(Long userId, Long clubId) {
        ClubEmbed clubEmbed = new ClubEmbed(userId, clubId);
        clubApplyRepository.deleteById(clubEmbed);
    }

    private void checkClubAdmin(Long clubId) {
        Long myId = authFacade.getUser().getId();
        clubFacade.checkClubAdminByUserId(myId, clubId);
    }
}
