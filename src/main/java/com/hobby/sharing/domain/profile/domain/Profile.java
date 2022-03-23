package com.hobby.sharing.domain.profile.domain;

import com.hobby.sharing.domain.model.BaseTime;
import com.hobby.sharing.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "user_profile")
public class Profile extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "profile_image_url", length = 50, nullable = false)
    private String profileImageUrl;

    @Column(name = "status_message", length = 30, nullable = false)
    private String statusMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Profile(User user, String profileImageUrl, String statusMessage) {
        this.user = user;
        this.profileImageUrl = profileImageUrl;
        this.statusMessage = statusMessage;
    }
}
