package com.hobby.sharing.domain.club.dao;

import com.hobby.sharing.domain.club.dto.response.ClubListResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hobby.sharing.domain.club.domain.QClub.club;
import static com.hobby.sharing.domain.hobby.domain.QHobby.hobby;
import static com.hobby.sharing.domain.hobby.domain.QLikeHobby.likeHobby;
import static com.querydsl.core.types.Projections.constructor;

@RequiredArgsConstructor
@Repository
public class CustomClubRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<ClubListResponse> getClubList(Long userId) {
        return jpaQueryFactory
                .select(constructor(ClubListResponse.class,
                        hobby.id,
                        hobby.name,
                        club.name,
                        hobby.category.name,
                        club.managerEmail,
                        club.introMessage))
                .from(hobby)
                .join(club).on(club.hobby.id.eq(hobby.id))
                .join(likeHobby).on(likeHobby.user.id.eq(userId)
                                .and(likeHobby.hobby.id.eq(hobby.id)))
                .orderBy(hobby.name.asc())
                .fetch();
    }
}