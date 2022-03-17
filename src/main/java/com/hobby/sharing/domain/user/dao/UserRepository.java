package com.hobby.sharing.domain.user.dao;

import com.hobby.sharing.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
