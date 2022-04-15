package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.CustomProfileRepository;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileDetailsInfoService {

    private final AuthFacade authFacade;

    private final CustomProfileRepository customProfileRepository;

    public ProfileDetailsInfoResponse execute() {
        Long userId = authFacade.getUser().getId();
        return customProfileRepository.getProfileDetailsInfo(userId);
    }
}