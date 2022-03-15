package com.hobby.sharing.domain.profile.domain;

import com.hobby.sharing.domain.model.BaseTime;
import com.hobby.sharing.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Profile extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) default 'no profile image", nullable = false)
    private String profileImageUrl;

    @Column(length = 30, nullable = false)
    private String statusMessage;

    @Builder
    public Profile(User user, String profileImageUrl, String statusMessage) {
        this.user = user;
        this.profileImageUrl = profileImageUrl;
        this.statusMessage = statusMessage;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
