package com.hobby.sharing.domain.user.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.hobby.sharing.domain.user.domain.QUser.user;

@RequiredArgsConstructor
@Repository
public class CustomUserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<String> findPasswordByEmail(String email) {
        return Optional.ofNullable(jpaQueryFactory
                .select(user.password)
                .from(user)
                .where(user.email.eq(email))
                .fetchOne());
    }
}
