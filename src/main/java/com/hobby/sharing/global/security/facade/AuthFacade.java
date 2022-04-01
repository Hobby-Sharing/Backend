package com.hobby.sharing.global.security.facade;

import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import com.hobby.sharing.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthFacade {

    private final UserRepository userRepository;

    public User getUser() {
        String email = getUserEmail();
        return userRepository.findByEmail(email).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    private String getUserEmail() {
        return ((AuthDetails)getAuthentication().getPrincipal()).getUsername();
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
