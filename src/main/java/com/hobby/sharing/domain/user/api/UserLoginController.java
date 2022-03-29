package com.hobby.sharing.domain.user.api;

import com.hobby.sharing.domain.user.application.UserLoginService;
import com.hobby.sharing.domain.user.dto.request.LoginRequest;
import com.hobby.sharing.domain.user.dto.response.UserTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserLoginController {

    private final UserLoginService userLoginService;

    @PostMapping("/login")
    public UserTokenResponse login(@Valid @RequestBody LoginRequest request) {
        return userLoginService.execute(request);
    }
}
