package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.CustomProfileRepository;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import com.hobby.sharing.global.security.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileDetailsInfoService {

    private final AuthFacade authFacade;
    private final CustomProfileRepository customProfileRepository;

    public ProfileDetailsInfoResponse execute() {
        String email = authFacade.getUserEmail();
        return customProfileRepository.getProfileDetailsInfo(email);
    }
}