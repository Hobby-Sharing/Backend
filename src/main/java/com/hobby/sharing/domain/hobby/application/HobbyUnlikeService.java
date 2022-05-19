package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.application.facade.HobbyFacade;
import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.dto.request.LikeHobbyRequest;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class HobbyUnlikeService {

    private final AuthFacade authFacade;
    private final HobbyFacade hobbyFacade;

    private final LikeHobbyRepository likeHobbyRepository;


    @Transactional
    public void execute(LikeHobbyRequest request) {
        User user = authFacade.getUser();

        hobbyFacade.checkLikeHobbyExists(UUID.fromString(request.getHobbyId()), user.getId());

        likeHobbyRepository.deleteByHobbyIdAndUserId(UUID.fromString(request.getHobbyId()), user.getId());
    }
}