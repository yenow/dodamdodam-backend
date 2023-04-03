package com.ysy.dodamdodam.domain.user.repository;

import com.ysy.dodamdodam.domain.user.entity.User;

public interface UserCustomRepository {

    User findByIdForTest(Long userId);
}
