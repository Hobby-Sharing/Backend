package com.hobby.sharing.domain.user.domain;

import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import com.hobby.sharing.domain.model.BaseTimeEntity;
import com.hobby.sharing.domain.profile.domain.Profile;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 8, nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Builder
    public User(String email, String password, String name, String address, int zipcode) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = new Address(address, zipcode);
    }

    @OneToMany(mappedBy = "user")
    private List<Profile> profileList;

    @OneToMany(mappedBy = "user")
    private List<LikeHobby> likeHobbyList;
}
