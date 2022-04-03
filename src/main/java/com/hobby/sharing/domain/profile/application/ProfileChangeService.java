package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.ProfileRepository;
import com.hobby.sharing.domain.profile.domain.Profile;
import com.hobby.sharing.domain.profile.dto.request.ProfileChangeRequest;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProfileChangeService {

    private final AuthFacade authFacade;
    private final ProfileRepository profileRepository;

    @Transactional
    public void execute(ProfileChangeRequest request) {
        User user = authFacade.getUser();
        user.updateUserProfile(request.getName(), request.getZipCode(), request.getRoadNameAddress());

        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        profile.updateProfile(request.getProfileImageUrl(), request.getStatusMessage());
    }
}
