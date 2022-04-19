package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface LikeHobbyRepository extends CrudRepository<LikeHobby, Long> {
    List<LikeHobby> findAllByUserId(Long userId, Sort sort);
    void deleteByHobbyIdAndUserId(UUID hobbyId, Long userId);
    boolean existsByHobbyIdAndUserId(UUID hobbyId, Long userId);
}