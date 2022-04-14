package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.exception.ClubAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClubFacade {

    private ClubRepository clubRepository;

    public void checkClubNameExists(String clubName) {
        if (clubRepository.existsByName(clubName)) {
            throw ClubAlreadyExistsException.EXCEPTION;
        }
    }
}
