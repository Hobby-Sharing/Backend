package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.ClubMember;
import com.hobby.sharing.domain.club.domain.role.ClubRole;
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest;
import com.hobby.sharing.domain.club.exception.ClubAlreadyExistsException;
import com.hobby.sharing.domain.hobby.dao.HobbyRepository;
import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.hobby.exception.HobbyNotFoundException;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateClubService {

    private final AuthFacade authFacade;
    private final ClubRepository clubRepository;
    private final HobbyRepository hobbyRepository;
    private final ClubMemberRepository clubMemberRepository;

    public void execute(CreateClubRequest request) {
        User user = authFacade.getUser();
        Hobby hobby = hobbyRepository.findById(request.getHobbyId())
                .orElseThrow(() -> HobbyNotFoundException.EXCEPTION);

        Club club = Club.builder()
                .name(request.getName())
                .introMessage(request.getIntroMessage())
                .hobby(hobby)
                .managerEmail(user.getEmail())
                .build();
        checkClubExists(club.getName());
        clubRepository.save(club);

        ClubMember clubMember = ClubMember.builder()
                .user(user)
                .club(club)
                .role(ClubRole.ADMIN)
                .build();
        clubMemberRepository.save(clubMember);
    }

    private void checkClubExists(String clubName) {
        if (clubRepository.existsByName(clubName)) {
            throw ClubAlreadyExistsException.EXCEPTION;
        }
    }
}
