package com.hobby.sharing.domain.profile.api;

import com.hobby.sharing.domain.profile.application.ProfileRegistrationService;
import com.hobby.sharing.domain.profile.dto.request.ProfileRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProfileRegistrationController {

    private final ProfileRegistrationService profileRegistrationService;

    @PostMapping("/profile") @PreAuthorize("isAuthenticated()")
    public void profileRegistration(@Valid @RequestBody ProfileRegistrationRequest request) {
        profileRegistrationService.execute(request);
    }
}
