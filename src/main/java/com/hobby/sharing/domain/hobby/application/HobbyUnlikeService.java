package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.dto.request.LikeHobbyRequest;
import com.hobby.sharing.domain.hobby.exception.HobbyNotFoundException;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class HobbyUnlikeService {

    private final AuthFacade authFacade;
    private final LikeHobbyRepository likeHobbyRepository;

    @Transactional
    public void execute(LikeHobbyRequest request) {
        User user = authFacade.getUser();

        likeHobbyRepository.findByHobbyIdAndUserId(request.getHobbyId(), user.getId())
                        .orElseThrow(() -> HobbyNotFoundException.EXCEPTION);

        likeHobbyRepository.deleteByHobbyIdAndUserId(request.getHobbyId(), user.getId());
    }
}