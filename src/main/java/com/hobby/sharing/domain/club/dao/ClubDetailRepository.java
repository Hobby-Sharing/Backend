package com.hobby.sharing.domain.club.dao;

import com.hobby.sharing.domain.club.domain.ClubDetail;
import com.hobby.sharing.domain.club.domain.ClubId;
import org.springframework.data.repository.CrudRepository;

public interface ClubDetailRepository extends CrudRepository<ClubDetail, ClubId> {
}
