package com.hobby.sharing.domain.club.dao;

import com.hobby.sharing.domain.club.domain.Club;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club, Long> {
    boolean existsByName(String name);
}