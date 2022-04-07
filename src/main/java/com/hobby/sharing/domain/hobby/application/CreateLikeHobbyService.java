package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.application.facade.HobbyFacade;
import com.hobby.sharing.domain.hobby.dao.HobbyRepository;
import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import com.hobby.sharing.domain.hobby.dto.request.CreateLikeHobbyRequest;
import com.hobby.sharing.domain.hobby.exception.HobbyNotFoundException;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CreateLikeHobbyService {

    private final AuthFacade authFacade;
    private final HobbyFacade hobbyFacade;
    private final HobbyRepository hobbyRepository;
    private final LikeHobbyRepository likeHobbyRepository;

    public void execute(CreateLikeHobbyRequest request) {
        User user = authFacade.getUser();
        Hobby hobby = hobbyRepository.findById(request.getHobbyId())
                .orElseThrow(() -> HobbyNotFoundException.EXCEPTION);

        LikeHobby likeHobby = LikeHobby.builder()
                .hobby(hobby)
                .user(user)
                .build();
        hobbyFacade.checkLikeHobbyDuplicate(hobby.getId(), user.getId());
        likeHobbyRepository.save(likeHobby);
    }
}
