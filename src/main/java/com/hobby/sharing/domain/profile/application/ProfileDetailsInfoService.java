package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.CustomProfileRepository;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileDetailsInfoService {

    public static final String PROFILE = "profile";

    private final AuthFacade authFacade;

    private final CustomProfileRepository customProfileRepository;


    @Cacheable(value = "profile", key = "#root.target.PROFILE", cacheManager = "cacheManager")
    public ProfileDetailsInfoResponse execute() {
        User user = authFacade.getUser();
        return customProfileRepository.getProfileDetailsInfo(user.getId());
    }
}