package com.hobby.sharing.domain.club.dao;

import com.hobby.sharing.domain.club.domain.ClubApply;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import org.springframework.data.repository.CrudRepository;

public interface ClubApplyRepository extends CrudRepository<ClubApply, ClubEmbed> {
}