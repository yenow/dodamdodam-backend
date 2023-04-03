package com.ysy.dodamdodam.domain.user.dto;

import com.ysy.dodamdodam.domain.user.entity.Gender;
import com.ysy.dodamdodam.domain.user.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String nickname;
    @NotNull
    private String birthDay;
    @NotNull
    private Gender gender;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .nickname(nickname)
                .birthDay(birthDay)
                .gender(gender)
                .password(password)
                .build();
    }
}
