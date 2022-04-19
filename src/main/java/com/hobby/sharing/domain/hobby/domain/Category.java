package com.hobby.sharing.domain.hobby.domain;

import com.hobby.sharing.domain.model.BaseTime;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity @Table(name = "category")
public class Category extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Hobby> hobbyList;
}