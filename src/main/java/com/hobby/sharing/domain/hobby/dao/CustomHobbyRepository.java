package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import com.hobby.sharing.domain.hobby.dto.response.SelectLikeHobbyResponse;
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

    public List<HobbyListResponse> getAllHobby(PagingRequest request) {
        return jpaQueryFactory
                .select(constructor(HobbyListResponse.class,
                        hobby.id,
                        hobby.name,
                        hobby.category.name))
                .from(hobby)
                .orderBy(hobby.name.asc())
                .offset(request.getSize() * request.getPageNo())
                .limit(request.getSize())
                .fetch();
    }


    public List<SelectLikeHobbyResponse> getAllLikeHobby(Long userId) {
        return jpaQueryFactory
                .select(constructor(SelectLikeHobbyResponse.class,
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
