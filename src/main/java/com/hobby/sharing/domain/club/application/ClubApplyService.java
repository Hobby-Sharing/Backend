package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubDetailRepository;
import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.ClubDetail;
import com.hobby.sharing.domain.club.exception.ClubNotFoundException;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClubApplyService {

    private final AuthFacade authFacade;
    private final ClubFacade clubFacade;
    
    private final ClubRepository clubRepository;
    private final ClubDetailRepository clubDetailRepository;

    public void execute(Long clubId) {
        User user = authFacade.getUser();
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        clubFacade.checkClubApplyCondition(user.getId(), clubId);

        ClubDetail clubDetail = ClubDetail.builder()
                .user(user)
                .club(club)
                .build();
        clubDetailRepository.save(clubDetail);
    }
}