package com.hobby.sharing.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpRequest {

    @NotBlank(message = "이메일은 비어 있을 수 없습니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$",
            message = "비밀번호는 적어도 하나의 숫자와 소문자를 포함한 8글자 이상이어야 하며, 공백이 포함될 수 없습니다.")
    private String password;

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
