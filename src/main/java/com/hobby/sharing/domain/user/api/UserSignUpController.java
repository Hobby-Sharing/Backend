package com.hobby.sharing.domain.user.api;

import com.hobby.sharing.domain.user.application.UserSignUpService;
import com.hobby.sharing.domain.user.dto.request.UserSignUpRequest;
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
public class UserSignUpController {

    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public UserTokenResponse userSignUp(@Valid @RequestBody UserSignUpRequest userSignUpRequest) {
        return userSignUpService.execute(userSignUpRequest);
    }
}
