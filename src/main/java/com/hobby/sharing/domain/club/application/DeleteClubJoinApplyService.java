package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubApplyRepository;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.club.dto.request.ClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteClubJoinApplyService {

    private final ClubFacade clubFacade;

    private final ClubApplyRepository clubApplyRepository;


    public void execute(ClubRequest request) {
        clubFacade.checkClubAdmin(request.getClubId());
        clubFacade.checkClubApplyExists(request.getUserId(), request.getClubId());

        ClubEmbed clubEmbed = new ClubEmbed(request.getUserId(), request.getClubId());

        clubApplyRepository.deleteById(clubEmbed);
    }
}
