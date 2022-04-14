package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.dao.CustomClubRepository;
import com.hobby.sharing.domain.club.exception.ClubAlreadyExistsException;
import com.hobby.sharing.domain.club.exception.ClubDetailAlreadyExistsException;
import com.hobby.sharing.domain.club.exception.ClubMemberAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClubFacade {

    private final ClubRepository clubRepository;
    private final CustomClubRepository customClubRepository;

    public void checkClubNameExists(String clubName) {
        if (clubRepository.existsByName(clubName)) {
            throw ClubAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkClubDetailExists(Long userId, Long clubId) {
        if(customClubRepository.existsClubDetail(userId, clubId)) {
            throw ClubDetailAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkClubMemberExists(Long userId, Long clubId) {
        if(customClubRepository.existsClubMember(userId, clubId)) {
            throw ClubMemberAlreadyExistsException.EXCEPTION;
        }
    }
}
