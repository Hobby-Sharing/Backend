package com.hobby.sharing.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotBlank(message = "이메일은 비어 있을 수 없습니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @Size(max = 64, message = "이메일은 최대 64글자까지만 가능합니다.")
    private String email;

    @NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$",
            message = "비밀번호는 적어도 하나의 숫자와 소문자를 포함한 8글자 이상이어야 하며, 공백이 포함될 수 없습니다.")
    @Size(max = 60, message = "비밀번호는 최대 60글자까지만 가능합니다.")
    private String password;

}
