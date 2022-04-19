package com.hobby.sharing.domain.club.application;

import com.hobby.sharing.domain.club.dao.CustomClubRepository;
import com.hobby.sharing.domain.club.dto.response.ClubListResponse;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClubListService {

    public static final String CLUB_LIST = "clubList";

    private final AuthFacade authFacade;

    private final CustomClubRepository customClubRepository;

    @Cacheable(value = "club", key = "#root.target.CLUB_LIST", cacheManager = "cacheManager")
    public List<ClubListResponse> execute() {
        Long userId = authFacade.getUser().getId();
        return customClubRepository.getClubList(userId);
    }
}