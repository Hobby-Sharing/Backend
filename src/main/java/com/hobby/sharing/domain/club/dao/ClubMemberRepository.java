package com.hobby.sharing.domain.club.dao;

import com.hobby.sharing.domain.club.domain.embed.ClubId;
import com.hobby.sharing.domain.club.domain.ClubMember;
import org.springframework.data.repository.CrudRepository;

public interface ClubMemberRepository extends CrudRepository<ClubMember, ClubId> {
}