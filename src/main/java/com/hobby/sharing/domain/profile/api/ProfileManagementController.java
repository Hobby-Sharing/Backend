package com.hobby.sharing.domain.profile.api;

import com.hobby.sharing.domain.profile.application.ProfileChangeService;
import com.hobby.sharing.domain.profile.application.ProfileDetailsInfoService;
import com.hobby.sharing.domain.profile.application.ProfileRegistrationService;
import com.hobby.sharing.domain.profile.dto.request.ProfileChangeRequest;
import com.hobby.sharing.domain.profile.dto.request.ProfileRegistrationRequest;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProfileManagementController {

    private final ProfileDetailsInfoService profileDetailsInfoService;
    private final ProfileRegistrationService profileRegistrationService;
    private final ProfileChangeService profileChangeService;

    @GetMapping("/profile") @PreAuthorize("isAuthenticated()")
    public ProfileDetailsInfoResponse getProfileDetails() {
        return profileDetailsInfoService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/profile") @PreAuthorize("isAuthenticated()")
    public void profileRegistration(@Valid @RequestBody ProfileRegistrationRequest request) {
        profileRegistrationService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/profile") @PreAuthorize("isAuthenticated()")
    public void profileChange(@Valid @RequestBody ProfileChangeRequest request) {
        profileChangeService.execute(request);
    }
}
