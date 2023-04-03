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
public class UserSaveResponseDto {
    @NotNull
    private String email;
    @NotNull
    private String nickname;
    @NotNull
    private String birthDay;
    @NotNull
    private Gender gender;
    private String password;

    static public UserSaveResponseDto toDto(User user) {
        return UserSaveResponseDto.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .birthDay(user.getBirthDay())
                .gender(user.getGender())
                .password(user.getPassword())
                .build();
    }
}
