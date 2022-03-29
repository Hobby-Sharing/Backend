package com.hobby.sharing.domain.user.facade;

import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public void checkUserExists(String email) {
        if(userRepository.existsByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }
}
