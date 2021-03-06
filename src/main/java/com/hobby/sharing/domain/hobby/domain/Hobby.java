package com.hobby.sharing.domain.hobby.domain;

import com.hobby.sharing.domain.club.domain.Club;
import com.hobby.sharing.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "hobby")
public class Hobby extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Hobby(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    @OneToMany(mappedBy = "hobby")
    private List<LikeHobby> likeHobbyList;

    @OneToMany(mappedBy = "hobby")
    private List<Club> clubList;
}