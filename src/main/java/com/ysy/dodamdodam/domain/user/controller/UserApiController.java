package com.ysy.dodamdodam.domain.user.controller;

import com.ysy.dodamdodam.domain.user.dto.UserSaveRequestDto;
import com.ysy.dodamdodam.domain.user.dto.UserSaveResponseDto;
import com.ysy.dodamdodam.domain.user.service.UserService;
import com.ysy.dodamdodam.global.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    final private UserService userService;


    /**
     * 회원 등록 Api
     *
     * @param userSaveRequestDto
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ResponseDto saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        UserSaveResponseDto userSaveResponseDto = userService.saveUser(userSaveRequestDto);

        return ResponseDto.builder()
                .isSuccess(true)
                .body(userSaveResponseDto)
                .build();
    }

}
