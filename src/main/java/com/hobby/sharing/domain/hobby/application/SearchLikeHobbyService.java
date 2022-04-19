package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.CustomHobbyRepository;
import com.hobby.sharing.domain.hobby.dto.response.LikeHobbyResponse;
import com.hobby.sharing.global.security.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchLikeHobbyService {

    private final AuthFacade authFacade;

    private final CustomHobbyRepository customHobbyRepository;

    @Transactional(readOnly = true)
    public List<LikeHobbyResponse> execute() {
        Long userId = authFacade.getUser().getId();
        return customHobbyRepository.getAllLikeHobby(userId);
    }
}