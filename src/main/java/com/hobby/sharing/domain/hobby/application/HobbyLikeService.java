package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.application.facade.HobbyFacade;
import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import com.hobby.sharing.domain.hobby.dto.request.LikeHobbyRequest;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class HobbyLikeService {

    private final AuthFacade authFacade;
    private final HobbyFacade hobbyFacade;

    private final LikeHobbyRepository likeHobbyRepository;


    public void execute(LikeHobbyRequest request) {
        User user = authFacade.getUser();
        Hobby hobby = hobbyFacade.getHobbyById(request.getHobbyId());

        hobbyFacade.checkLikeHobbyDuplicate(hobby.getId(), user.getId());

        LikeHobby likeHobby = LikeHobby.builder()
                .hobby(hobby)
                .user(user)
                .build();
        likeHobbyRepository.save(likeHobby);
    }
}