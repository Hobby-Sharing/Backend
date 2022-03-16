package com.hobby.sharing.domain.club.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ClubId implements Serializable {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "club_id", nullable = false)
    private Long clubId;

}
