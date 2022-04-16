package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.dao.CustomClubRepository;
import com.hobby.sharing.domain.club.dto.response.ClubListResponse;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClubListService {

    private final AuthFacade authFacade;

    private final CustomClubRepository customClubRepository;

    public List<ClubListResponse> execute() {
        User user = authFacade.getUser();
        return customClubRepository.getClubList(user.getId());
    }
}