package com.hobby.sharing.domain.hobby.application.facade;

import com.hobby.sharing.domain.hobby.dao.HobbyRepository;
import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository;
import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.hobby.exception.HobbyNotFoundException;
import com.hobby.sharing.domain.hobby.exception.LikeHobbyAlreadyExistsException;
import com.hobby.sharing.domain.hobby.exception.LikeHobbyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HobbyFacade {

    private final HobbyRepository hobbyRepository;
    private final LikeHobbyRepository likeHobbyRepository;


    public Hobby getHobbyById(String hobbyId) {
        return hobbyRepository.findById(UUID.fromString(hobbyId))
                .orElseThrow(() -> HobbyNotFoundException.EXCEPTION);
    }

    public void checkLikeHobbyDuplicate(UUID hobbyId, Long userId) {
        if (likeHobbyRepository.existsByHobbyIdAndUserId(hobbyId, userId)) {
            throw LikeHobbyAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkLikeHobbyExists(UUID hobbyId, Long userId) {
        if (!likeHobbyRepository.existsByHobbyIdAndUserId(hobbyId, userId)) {
            throw LikeHobbyNotFoundException.EXCEPTION;
        }
    }
}
