package com.hobby.sharing.domain.user.application.facade;

import com.hobby.sharing.domain.user.dao.CustomUserRepository;
import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.exception.PasswordMismatchException;
import com.hobby.sharing.domain.user.exception.UserAlreadyExistsException;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
