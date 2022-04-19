package com.hobby.sharing.domain.profile.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileChangeRequest {

    @NotBlank(message = "프로필 이미지 URL은 비어 있을 수 없습니다.")
    private String profileImageUrl;

    @Size(max = 30, message = "상태 메시지는 30글자를 초과할 수 없습니다.")
    @NotBlank(message = "상태 메시지는 비어 있을 수 없습니다.")
    private String statusMessage;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 8, message = "이름은 8글자 이하여야 합니다.")
    private String name;

    @NotNull(message = "우편번호를 입력해주세요.")
    @Min(value = 9999, message = "우편번호 5자리가 올바르게 입력되었는지 확인해주세요.")
    @Digits(integer = 5, fraction = 0, message = "우편번호 5자리가 올바르게 입력되었는지 확인해주세요.")
    private Integer zipCode;

    @NotBlank(message = "도로명주소를 입력해주세요.")
    private String roadNameAddress;
}
