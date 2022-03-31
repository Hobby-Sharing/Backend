package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.CustomProfileRepository;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileDetailsInfoService {

    private final CustomProfileRepository customProfileRepository;

    public ProfileDetailsInfoResponse execute() {
        return customProfileRepository.getProfileDetailsInfo();
    }
}