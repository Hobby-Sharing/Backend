package com.hobby.sharing.domain.hobby.application.facade;

import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.exception.LikeHobbyAlreadyExistsException;
import com.hobby.sharing.domain.hobby.exception.LikeHobbyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HobbyFacade {

    private final LikeHobbyRepository likeHobbyRepository;

    public void checkLikeHobbyDuplicate(UUID hobbyId, Long userId) {
        if (likeHobbyRepository.existsByHobbyIdAndUserId(hobbyId, userId)) {
            throw LikeHobbyAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkLikeHobbyExists(UUID hobbyId, Long userId) {
        if(likeHobbyRepository.existsByHobbyIdAndUserId(hobbyId, userId)) {
            throw LikeHobbyNotFoundException.EXCEPTION;
        }
    }
}
