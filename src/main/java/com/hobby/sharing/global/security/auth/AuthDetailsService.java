package com.hobby.sharing.global.security.auth;

import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(userRepository.existsByEmail(email)) {
            return new AuthDetails(email);
        } else {
            throw UserNotFoundException.EXCEPTION;
        }
    }
}
