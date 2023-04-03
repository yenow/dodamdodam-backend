package com.ysy.dodamdodam.domain.user.service;

import com.ysy.dodamdodam.domain.user.dto.UserSaveRequestDto;
import com.ysy.dodamdodam.domain.user.dto.UserSaveResponseDto;
import com.ysy.dodamdodam.domain.user.entity.User;
import com.ysy.dodamdodam.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {
        User user = userRepository.save(userSaveRequestDto.toEntity());
        return UserSaveResponseDto.toDto(user);
    }
}
