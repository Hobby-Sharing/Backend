package com.hobby.sharing.domain.profile.dao;


import com.hobby.sharing.domain.profile.dto.response.ProfileDetailsInfoResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hobby.sharing.domain.profile.domain.QProfile.profile;
import static com.hobby.sharing.domain.user.domain.QUser.user;
import static com.querydsl.core.types.Projections.constructor;

@RequiredArgsConstructor
@Repository
public class CustomProfileRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ProfileDetailsInfoResponse getProfileDetailsInfo(Long userId) {
        return jpaQueryFactory
                .select(constructor(ProfileDetailsInfoResponse.class,
                        user.email,
                        user.name,
                        profile.profileImageUrl,
                        profile.statusMessage,
                        user.address.zipCode,
                        user.address.roadNameAddress))
                .from(user)
                .leftJoin(profile).on(profile.user.id.eq(user.id))
                .where(user.id.eq(userId))
                .fetchOne();
    }
}
