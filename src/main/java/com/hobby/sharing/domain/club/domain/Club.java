package com.hobby.sharing.domain.club.domain;

import com.hobby.sharing.domain.hobby.domain.Hobby;
import com.hobby.sharing.domain.model.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Club extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 30)
    private String introductionMessage;

    @Column(length = 64, nullable = false)
    private String managerEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    @Builder
    public Club(String name, String introductionMessage, String managerEmail, Hobby hobby) {
        this.name = name;
        this.introductionMessage = introductionMessage;
        this.managerEmail = managerEmail;
        this.hobby = hobby;
    }

    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    private List<ClubDetail> clubDetailList;

}
