package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubApplyRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.ClubApply;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyClubJoinService {

    private final AuthFacade authFacade;
    private final ClubFacade clubFacade;

    private final ClubApplyRepository clubApplyRepository;


    public void execute(Long clubId) {
        User user = authFacade.getUser();
        Club club = clubFacade.getClubById(clubId);

        checkApplyClubJoin(user.getId(), club.getId());

        ClubApply clubApply = ClubApply.builder()
                .user(user)
                .club(club)
                .build();
        clubApplyRepository.save(clubApply);
    }

    public void checkApplyClubJoin(Long userId, Long clubId) {
        clubFacade.checkClubMemberNotExists(userId, clubId);
        clubFacade.checkClubApplyNotExists(userId, clubId);
    }
}