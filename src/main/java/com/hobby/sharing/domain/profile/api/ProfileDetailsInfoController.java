package com.hobby.sharing.domain.profile.api;

import com.hobby.sharing.domain.profile.application.ProfileDetailsInfoService;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProfileDetailsInfoController {

    private final ProfileDetailsInfoService profileDetailsInfoService;

    @GetMapping("/profile") @PreAuthorize("isAuthenticated()")
    public ProfileDetailsInfoResponse getProfileDetails() {
        return profileDetailsInfoService.execute();
    }
}
