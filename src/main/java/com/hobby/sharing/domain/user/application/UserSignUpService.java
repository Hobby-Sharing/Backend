package com.hobby.sharing.domain.user.application;

import com.hobby.sharing.domain.user.dao.UserRepository;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.domain.user.dto.request.UserSignUpRequest;
import com.hobby.sharing.domain.user.dto.response.UserTokenResponse;
import com.hobby.sharing.domain.user.application.facade.UserFacade;
import com.hobby.sharing.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public UserTokenResponse execute(UserSignUpRequest request) {
        userFacade.checkUserDuplicate(request.getEmail());

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .zipcode(request.getZipCode())
                .roadNameAddress(request.getRoadNameAddress())
                .build();
        userRepository.save(user);

        String accessToken = jwtTokenProvider.generateAccessToken(request.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getEmail());
        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
