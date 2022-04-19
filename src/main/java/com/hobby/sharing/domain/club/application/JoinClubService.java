package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubDetailRepository;
import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.ClubMember;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.club.domain.role.ClubRole;
import com.hobby.sharing.domain.club.dto.request.ClubRequest;
import com.hobby.sharing.domain.club.exception.ClubNotFoundException;
import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinClubService {

    private final ClubFacade clubFacade;

    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final ClubMemberRepository clubMemberRepository;
    private final ClubDetailRepository clubDetailRepository;

    public void execute(ClubRequest request) {
        clubFacade.checkClubAdmin(request.getClubId());
        clubFacade.checkClubJoinCondition(request.getUserId(), request.getClubId());

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        Club club = clubRepository.findById(request.getClubId())
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        ClubMember clubMember = ClubMember.builder()
                .user(user)
                .club(club)
                .role(ClubRole.USER)
                .build();
        clubMemberRepository.save(clubMember);
        deleteClubDetail(user.getId(), club.getId());
    }

    private void deleteClubDetail(Long userId, Long clubId) {
        ClubEmbed clubEmbed = new ClubEmbed(userId, clubId);
        clubDetailRepository.deleteById(clubEmbed);
    }
}
