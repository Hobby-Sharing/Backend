package com.hobby.sharing.domain.profile.api;

import com.hobby.sharing.domain.profile.application.ProfileDetailsInfoService;
import com.hobby.sharing.domain.profile.application.ProfileRegistrationService;
import com.hobby.sharing.domain.profile.dto.request.ProfileRegistrationRequest;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProfileManagementController {

    private final ProfileDetailsInfoService profileDetailsInfoService;
    private final ProfileRegistrationService profileRegistrationService;

    @GetMapping("/profile") @PreAuthorize("isAuthenticated()")
    public ProfileDetailsInfoResponse getProfileDetails() {
        return profileDetailsInfoService.execute();
    }

    @PostMapping("/profile") @PreAuthorize("isAuthenticated()")
    public void profileRegistration(@Valid @RequestBody ProfileRegistrationRequest request) {
        profileRegistrationService.execute(request);
    }
}
