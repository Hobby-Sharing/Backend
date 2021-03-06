package com.hobby.sharing.domain.user.application;

import com.hobby.sharing.domain.user.application.facade.UserFacade;
import com.hobby.sharing.domain.user.dto.request.LoginRequest;
import com.hobby.sharing.domain.user.dto.response.UserTokenResponse;
import com.hobby.sharing.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {

    private final UserFacade userFacade;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(rollbackFor = Exception.class)
    public UserTokenResponse execute(LoginRequest request) {
        userFacade.checkEmailAndPassword(request.getEmail(), request.getPassword());

        String accessToken = jwtTokenProvider.generateAccessToken(request.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getEmail());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
