package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.domain.Hobby;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface HobbyRepository extends CrudRepository<Hobby, UUID> {
    List<Hobby> findByNameContains(String keyword, Sort sort);
}