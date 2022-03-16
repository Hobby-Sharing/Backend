package com.hobby.sharing.domain.club.domain;

import com.hobby.sharing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ClubDetail {

    @EmbeddedId
    private ClubId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private Club club;

    @Builder
    public ClubDetail(User user, Club club) {
        this.id = new ClubId(user.getId(), club.getId());
        this.user = user;
        this.club = club;
    }
}
