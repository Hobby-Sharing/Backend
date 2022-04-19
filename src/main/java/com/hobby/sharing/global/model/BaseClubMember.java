package com.hobby.sharing.global.model;

import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed;
import com.hobby.sharing.domain.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public class BaseClubMember {

    @EmbeddedId
    @AttributeOverride(name = "userId", column = @Column(name = "user_id"))
    @AttributeOverride(name = "clubId", column = @Column(name = "club_id"))
    protected ClubEmbed id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    protected User user;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    protected Club club;
}
