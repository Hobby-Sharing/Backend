package com.hobby.sharing.domain.user.application.facade;

import com.hobby.sharing.domain.user.dao.CustomUserRepository;
import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.exception.PasswordMismatchException;
import com.hobby.sharing.domain.user.exception.UserAlreadyExistsException;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import com.hobby.sharing.global.security.exception.TokenRefreshException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final PasswordEncoder passwordEncoder;

    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;

    public void checkUserDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkEmailAndPassword(String email, String password) {
        String storedPassword = customUserRepository.findPasswordByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(password, storedPassword)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

    public void checkUserExistsByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw TokenRefreshException.EXCEPTION;
        }
    }
}