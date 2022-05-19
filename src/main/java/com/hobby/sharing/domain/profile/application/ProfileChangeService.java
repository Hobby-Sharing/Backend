package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.domain.Profile;
import com.hobby.sharing.domain.profile.dto.request.ProfileChangeRequest;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProfileChangeService {

    private final AuthFacade authFacade;
    private final ProfileFacade profileFacade;


    @Transactional
    public void execute(ProfileChangeRequest request) {
        User user = authFacade.getUser();
        Profile profile = profileFacade.getProfileByUser(user);

        user.updateUserProfile(request.getName(), request.getZipCode(), request.getRoadNameAddress());
        profile.updateProfile(request.getProfileImageUrl(), request.getStatusMessage());
    }
}
