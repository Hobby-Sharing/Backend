package com.hobby.sharing.domain.profile.api;

import com.hobby.sharing.domain.profile.application.ProfileChangeService;
import com.hobby.sharing.domain.profile.application.ProfileDetailsInfoService;
import com.hobby.sharing.domain.profile.dto.request.ProfileChangeRequest;
import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final ProfileChangeService profileChangeService;
    private final ProfileDetailsInfoService profileDetailsInfoService;


    @GetMapping("/profile") @PreAuthorize("isAuthenticated()")
    public ProfileDetailsInfoResponse getProfileDetails() {
        return profileDetailsInfoService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/profile") @PreAuthorize("isAuthenticated()")
    public void profileChange(@RequestBody @Valid ProfileChangeRequest request) {
        profileChangeService.execute(request);
    }
}
