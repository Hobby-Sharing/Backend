package com.hobby.sharing.domain.profile.dao;

import com.hobby.sharing.domain.profile.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
