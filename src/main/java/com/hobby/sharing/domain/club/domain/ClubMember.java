package com.hobby.sharing.domain.club.domain;

import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.club.domain.role.ClubRole;
import com.hobby.sharing.global.model.BaseClubMember;
import com.hobby.sharing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity @Table(name = "club_member")
public class ClubMember extends BaseClubMember {

    @Enumerated(EnumType.STRING)
    @Column(name = "CLUB_ROLE", length = 5, nullable = false)
    private ClubRole role;

    @Builder
    public ClubMember(User user, Club club, ClubRole role) {
        this.id = new ClubEmbed(user.getId(), club.getId());
        this.user = user;
        this.club = club;
        this.role = role;
    }
}
