package com.hobby.sharing.domain.profile.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileRegistrationRequest {

    @NotBlank(message = "프로필 이미지 URL은 비어 있을 수 없습니다.")
    private String profileImageUrl;

    @Size(max = 30, message = "상태 메시지는 30글자를 초과할 수 없습니다.")
    @NotBlank(message = "상태 메시지는 비어 있을 수 없습니다.")
    private String statusMessage;
}
