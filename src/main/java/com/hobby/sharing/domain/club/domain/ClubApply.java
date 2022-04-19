package com.hobby.sharing.domain.club.domain;

import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.model.BaseClubMember;
import com.hobby.sharing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "club_apply")
public class ClubApply extends BaseClubMember {

    @Builder
    public ClubApply(User user, Club club) {
        this.id = new ClubEmbed(user.getId(), club.getId());
        this.user = user;
        this.club = club;
    }
}
