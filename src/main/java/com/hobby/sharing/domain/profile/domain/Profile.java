package com.hobby.sharing.domain.profile.domain;

import com.hobby.sharing.global.model.BaseTimeEntity;
import com.hobby.sharing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "user_profile")
public class Profile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "profile_image_url", nullable = false)
    private String profileImageUrl;

    @Column(name = "status_message", length = 30, nullable = false)
    private String statusMessage;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Profile(User user, String profileImageUrl, String statusMessage) {
        this.user = user;
        this.profileImageUrl = profileImageUrl;
        this.statusMessage = statusMessage;
    }

    public void updateProfile(String profileImageUrl, String statusMessage) {
        this.profileImageUrl = profileImageUrl;
        this.statusMessage = statusMessage;
    }
}
