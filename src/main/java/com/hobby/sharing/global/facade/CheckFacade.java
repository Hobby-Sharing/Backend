package com.hobby.sharing.global.facade;

import com.hobby.sharing.domain.profile.dao.ProfileRepository;
import com.hobby.sharing.domain.profile.exception.ProfileAlreadyExistsException;
import com.hobby.sharing.domain.user.dao.CustomUserRepository;
import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.domain.user.exception.PasswordMismatchException;
import com.hobby.sharing.domain.user.exception.UserAlreadyExistsException;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CheckFacade {

    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public void checkUserDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkProfileDuplicate(User user ) {
        if (profileRepository.existsByUser(user)) {
            throw ProfileAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkEmailAndPassword(String email, String password) {
        String storedPassword = customUserRepository.findPasswordByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(password, storedPassword)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }
}
