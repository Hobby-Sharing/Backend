package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.dto.response.HobbyResponse;
import com.hobby.sharing.domain.hobby.dto.response.LikeHobbyResponse;
import com.hobby.sharing.domain.user.dto.request.PagingRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hobby.sharing.domain.hobby.domain.QHobby.hobby;
import static com.hobby.sharing.domain.hobby.domain.QLikeHobby.likeHobby;
import static com.querydsl.core.types.Projections.constructor;

@RequiredArgsConstructor
@Repository
public class CustomHobbyRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<HobbyResponse> getAllHobby(PagingRequest page) {
        return jpaQueryFactory
                .select(constructor(HobbyResponse.class,
                        hobby.id,
                        hobby.name,
                        hobby.category.name))
                .from(hobby)
                .orderBy(hobby.name.asc())
                .offset(page.getSize() * page.getNumber())
                .limit(page.getSize())
                .fetch();
    }

    public List<LikeHobbyResponse> getAllLikeHobby(Long userId) {
        return jpaQueryFactory
                .select(constructor(LikeHobbyResponse.class,
                        hobby.id,
                        hobby.name,
                        hobby.category.name))
                .from(likeHobby)
                .leftJoin(hobby).on(hobby.id.eq(likeHobby.hobby.id))
                .where(likeHobby.user.id.eq(userId))
                .orderBy(hobby.name.asc())
                .fetch();
    }
}
