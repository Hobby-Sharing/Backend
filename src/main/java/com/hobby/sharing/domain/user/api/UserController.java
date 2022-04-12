package com.hobby.sharing.domain.user.api;

import com.hobby.sharing.domain.user.application.TokenRefreshService;
import com.hobby.sharing.domain.user.application.UserLoginService;
import com.hobby.sharing.domain.user.application.UserSignUpService;
import com.hobby.sharing.domain.user.dto.request.LoginRequest;
import com.hobby.sharing.domain.user.dto.request.TokenRefreshRequest;
import com.hobby.sharing.domain.user.dto.request.UserSignUpRequest;
import com.hobby.sharing.domain.user.dto.response.TokenRefreshResponse;
import com.hobby.sharing.domain.user.dto.response.UserTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserLoginService userLoginService;
    private final UserSignUpService userSignUpService;
    private final TokenRefreshService tokenRefreshService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public UserTokenResponse userSignUp(@RequestBody @Valid UserSignUpRequest userSignUpRequest) {
        return userSignUpService.execute(userSignUpRequest);
    }

    @PostMapping("/login")
    public UserTokenResponse login(@RequestBody @Valid LoginRequest request) {
        return userLoginService.execute(request);
    }

    @PostMapping("/refresh")
    public TokenRefreshResponse tokenRefresh(@RequestBody @Valid TokenRefreshRequest request) {
        return tokenRefreshService.execute(request);
    }
}
