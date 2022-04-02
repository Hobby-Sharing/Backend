package com.hobby.sharing.domain.profile.dao;

import com.hobby.sharing.domain.profile.domain.Profile;
import com.hobby.sharing.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Optional<Profile> findByUser(User user);
    boolean existsByUser(User user);
}