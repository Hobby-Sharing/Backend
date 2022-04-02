package com.hobby.sharing.domain.profile.application.facade;

import com.hobby.sharing.domain.profile.dao.ProfileRepository;
import com.hobby.sharing.domain.profile.exception.ProfileAlreadyExistsException;
import com.hobby.sharing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfileFacade {

    private final ProfileRepository profileRepository;

    public void checkProfileDuplicate(User user) {
        if (profileRepository.existsByUser(user)) {
            throw ProfileAlreadyExistsException.EXCEPTION;
        }
    }
}