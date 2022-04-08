package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface LikeHobbyRepository extends CrudRepository<LikeHobby, Long> {
    Optional<LikeHobby> findByHobbyIdAndUserId(UUID hobbyID, Long userId);
    boolean existsByHobbyIdAndUserId(UUID hobbyId, Long userId);
    void deleteByHobbyIdAndUserId(UUID hobbyId, Long userId);
}
