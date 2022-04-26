package com.hobby.sharing.domain.user.domain;

import com.hobby.sharing.domain.Address.domain.Address;
import com.hobby.sharing.domain.club.domain.ClubApply;
import com.hobby.sharing.domain.club.domain.ClubMember;
import com.hobby.sharing.domain.hobby.domain.LikeHobby;
import com.hobby.sharing.domain.profile.domain.Profile;
import com.hobby.sharing.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "user")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", length = 64, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "name", length = 8, nullable = false)
    private String name;

    @Embedded
    @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code"))
    @AttributeOverride(name = "roadNameAddress", column = @Column(name = "road_name_address"))
    private Address address;

    public void updateUserProfile(String name, int zipCode, String roadNameAddress) {
        this.name = name;
        this.address = new Address(roadNameAddress, zipCode);
    }

    @Builder
    public User(String email, String password, String name, String roadNameAddress, int zipcode) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = new Address(roadNameAddress, zipcode);
    }
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Profile profileList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<LikeHobby> likeHobbyList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ClubApply> clubApplyList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ClubMember> clubMemberList;
}
