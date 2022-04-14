package com.hobby.sharing.domain.club.domain;

import com.hobby.sharing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity @Table(name = "club_member")
public class ClubMember {

    @EmbeddedId
    @AttributeOverride(name = "userId", column = @Column(name = "user_id"))
    @AttributeOverride(name = "clubId", column = @Column(name = "club_id"))
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
    public ClubMember(User user, Club club) {
        this.id = new ClubId(user.getId(), club.getId());
        this.user = user;
        this.club = club;
    }
}
