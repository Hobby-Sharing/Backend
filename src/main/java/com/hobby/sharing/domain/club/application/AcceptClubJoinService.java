package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubApplyRepository;
import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
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
public class AcceptClubJoinService {

    private final AuthFacade authFacade;
    private final ClubFacade clubFacade;

    private final ClubMemberRepository clubMemberRepository;
    private final ClubApplyRepository clubApplyRepository;


    public void execute(ClubRequest request) {
        User user = authFacade.getUser();
        Club club = clubFacade.getClubById(request.getClubId());

        clubFacade.checkClubAdmin(user.getId(), club.getId());
        checkAcceptClubJoin(request.getUserId(), club.getId());

        ClubMember clubMember = makeClubMember(user, club);

        clubMemberRepository.save(clubMember);
        deleteClubApply(user.getId(), club.getId());
    }

    private void checkAcceptClubJoin(Long targetUserId, Long clubId) {
        clubFacade.checkClubApplyExists(targetUserId, clubId);
        clubFacade.checkClubMemberNotExists(targetUserId, clubId);
    }

    private ClubMember makeClubMember(User user, Club club) {
        return ClubMember.builder()
                .user(user)
                .club(club)
                .role(ClubRole.USER)
                .build();
    }

    private void deleteClubApply(Long userId, Long clubId) {
        ClubEmbed clubEmbed = new ClubEmbed(userId, clubId);
        clubApplyRepository.deleteById(clubEmbed);
    }
}
