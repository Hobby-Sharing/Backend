package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.application.facade.ClubFacade;
import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.ClubMember;
import com.hobby.sharing.domain.club.domain.role.ClubRole;
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest;
import com.hobby.sharing.domain.hobby.application.facade.HobbyFacade;
import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateClubService {

    private final AuthFacade authFacade;
    private final ClubFacade clubFacade;
    private final HobbyFacade hobbyFacade;

    private final ClubRepository clubRepository;
    private final ClubMemberRepository clubMemberRepository;


    @CacheEvict(value = "club", allEntries = true)
    public void execute(CreateClubRequest request) {
        clubFacade.checkClubNameNotExists(request.getName());

        User user = authFacade.getUser();
        Hobby hobby = hobbyFacade.getHobbyById(request.getHobbyId());

        Club club = Club.builder()
                .name(request.getName())
                .introMessage(request.getIntroMessage())
                .hobby(hobby)
                .managerEmail(user.getEmail())
                .build();
        clubRepository.save(club);

        ClubMember clubMember = makeClubAdmin(user, club);

        clubMemberRepository.save(clubMember);
    }

    private ClubMember makeClubAdmin(User user, Club club) {
        return ClubMember.builder()
                .user(user)
                .club(club)
                .role(ClubRole.ADMIN)
                .build();
    }
}