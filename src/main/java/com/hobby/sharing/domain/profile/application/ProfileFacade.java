package com.hobby.sharing.domain.profile.application;

import com.hobby.sharing.domain.profile.dao.ProfileRepository;
import com.hobby.sharing.domain.profile.domain.Profile;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfileFacade {

    private final ProfileRepository profileRepository;

    public Profile getProfileByUser(User user) {
        return profileRepository.findByUser(user)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
