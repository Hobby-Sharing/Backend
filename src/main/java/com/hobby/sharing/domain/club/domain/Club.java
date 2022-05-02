package com.hobby.sharing.domain.club.domain;

import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "club")
public class Club extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", length = 16, nullable = false)
    private String name;

    @Column(name = "introduction_message", length = 30)
    private String introMessage;

    @Column(name = "manager_email", length = 64, nullable = false)
    private String managerEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    @Builder
    public Club(String name, String introMessage, String managerEmail, Hobby hobby) {
        this.name = name;
        this.introMessage = introMessage;
        this.managerEmail = managerEmail;
        this.hobby = hobby;
    }

    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    private List<ClubApply> clubApplyList;

    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    private List<ClubMember> clubMemberList;
}
