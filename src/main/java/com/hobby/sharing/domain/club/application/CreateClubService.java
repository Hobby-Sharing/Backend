package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest;
import com.hobby.sharing.domain.club.exception.ClubAlreadyExistsException;
import com.hobby.sharing.domain.hobby.dao.HobbyRepository;
import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.hobby.exception.HobbyNotFoundException;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateClubService {

    private final AuthFacade authFacade;
    private final ClubRepository clubRepository;
    private final HobbyRepository hobbyRepository;

    public void execute(CreateClubRequest request) {
        String email = authFacade.getUser().getEmail();
        Hobby hobby = hobbyRepository.findById(request.getHobbyId())
                .orElseThrow(() -> HobbyNotFoundException.EXCEPTION);

        Club club = Club.builder()
                .name(request.getName())
                .introMessage(request.getIntroMessage())
                .hobby(hobby)
                .managerEmail(email)
                .build();
        checkClubExists(club.getName());
        clubRepository.save(club);
    }

    private void checkClubExists(String clubName) {
        if (clubRepository.existsByName(clubName)) {
            throw ClubAlreadyExistsException.EXCEPTION;
        }
    }
}
