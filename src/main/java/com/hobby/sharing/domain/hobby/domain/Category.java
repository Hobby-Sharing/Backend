package com.hobby.sharing.domain.hobby.domain;

import com.hobby.sharing.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "category")
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    private List<Hobby> hobbyList;
}