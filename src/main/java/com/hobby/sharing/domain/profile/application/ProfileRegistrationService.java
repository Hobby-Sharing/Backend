package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.ProfileRepository;
import com.hobby.sharing.domain.profile.domain.Profile;
import com.hobby.sharing.domain.profile.dto.request.ProfileRegistrationRequest;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileRegistrationService {

    private final AuthFacade authFacade;
    private final ProfileRepository profileRepository;

    public void execute(ProfileRegistrationRequest request) {
        User user = authFacade.getUser();

        Profile profile = Profile.builder()
                .user(user)
                .profileImageUrl(request.getProfileImageUrl())
                .statusMessage(request.getStatusMessage())
                .build();
        profileRepository.save(profile);
    }
}