package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.dto.response.SelectLikeHobbyResponse;
import com.hobby.sharing.domain.user.domain.User;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchLikeHobbyService {

    private final AuthFacade authFacade;
    private final LikeHobbyRepository likeHobbyRepository;

    public List<SelectLikeHobbyResponse> execute() {
        User user = authFacade.getUser();

        return likeHobbyRepository.findAllByUserId(user.getId())
                .stream()
                .map(SelectLikeHobbyResponse::from)
                .toList();
    }
}