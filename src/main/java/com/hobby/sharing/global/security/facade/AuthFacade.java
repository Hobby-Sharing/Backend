package com.hobby.sharing.global.security.facade;

import com.hobby.sharing.global.security.auth.AuthDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthFacade {

    public String getUserEmail() {
        return ((AuthDetails)getAuthentication()).getUsername();
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
