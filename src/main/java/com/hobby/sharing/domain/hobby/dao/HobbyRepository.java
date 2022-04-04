package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.domain.Hobby;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HobbyRepository extends CrudRepository<Hobby, Long> {
    List<Hobby> findAll();
}
