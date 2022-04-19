package com.hobby.sharing.domain.user.application;

import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.dto.request.TokenRefreshRequest;
import com.hobby.sharing.domain.user.dto.response.TokenRefreshResponse;
import com.hobby.sharing.global.security.exception.TokenRefreshException;
import com.hobby.sharing.global.security.jwt.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenRefreshResponse execute(TokenRefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        Claims tokenBody = jwtTokenProvider.getTokenBody(refreshToken);
        checkRefreshToken(tokenBody);

        String email = jwtTokenProvider.getEmail(tokenBody);
        userExistsByEmail(email);

        String accessToken = jwtTokenProvider.generateAccessToken(email);
        return new TokenRefreshResponse(accessToken);
    }

    private void checkRefreshToken(Claims tokenBody) {
        if (!jwtTokenProvider.isRefreshToken(tokenBody)) {
            throw TokenRefreshException.EXCEPTION;
        }
    }

    private void userExistsByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw TokenRefreshException.EXCEPTION;
        }
    }
}
