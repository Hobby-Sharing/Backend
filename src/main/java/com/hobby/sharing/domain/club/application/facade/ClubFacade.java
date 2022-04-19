package com.hobby.sharing.domain.club.application.facade;

import com.hobby.sharing.domain.club.dao.ClubMemberRepository;
import com.hobby.sharing.domain.club.dao.ClubRepository;
import com.hobby.sharing.domain.club.dao.CustomClubRepository;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.club.exception.*;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClubFacade {

    private final AuthFacade authFacade;

    private final ClubRepository clubRepository;
    private final CustomClubRepository customClubRepository;
    private final ClubMemberRepository clubMemberRepository;

    public void checkClubNameNotExists(String clubName) {
        if (clubRepository.existsByName(clubName)) {
            throw ClubAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkClubMemberExists(ClubEmbed clubEmbed) {
        if (!clubMemberRepository.existsById(clubEmbed)) {
            throw ClubMemberNotFoundException.EXCEPTION;
        }
    }

    public void checkClubDetailExists(Long userId, Long clubId) {
        if (!customClubRepository.existsClubDetail(userId, clubId)) {
            throw ClubDetailNotFoundException.EXCEPTION;
        }
    }

    public void checkClubApplyCondition(Long userId, Long clubId) {
        checkClubMemberNotExists(userId, clubId);
        checkClubDetailNotExists(userId, clubId);
    }

    private void checkClubDetailNotExists(Long userId, Long clubId) {
        if (customClubRepository.existsClubDetail(userId, clubId)) {
            throw ClubDetailAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkClubJoinCondition(Long userId, Long clubId) {
        checkClubMemberNotExists(userId, clubId);
        checkClubDetailApplyExists(userId, clubId);
    }

    private void checkClubMemberNotExists(Long userId, Long clubId) {
        if (customClubRepository.existsClubMember(userId, clubId)) {
            throw ClubMemberAlreadyExistsException.EXCEPTION;
        }
    }

    private void checkClubDetailApplyExists(Long userId, Long clubId) {
        if (!customClubRepository.existsClubDetail(userId, clubId)) {
            throw ClubDetailNotFoundException.EXCEPTION;
        }
    }

    public void checkClubAdmin(Long clubId) {
        Long myId = authFacade.getUser().getId();
        checkClubAdminByUserId(myId, clubId);
    }

    private void checkClubAdminByUserId(Long userId, Long clubId) {
        if (!customClubRepository.confirmClubAdmin(userId, clubId)) {
            throw ClubAdminException.EXCEPTION;
        }
    }

}
