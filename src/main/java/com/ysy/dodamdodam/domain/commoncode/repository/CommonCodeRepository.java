package com.ysy.dodamdodam.domain.commoncode.repository;

import com.ysy.dodamdodam.domain.commoncode.entity.CommonCode;
import com.ysy.dodamdodam.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String>, CommonCodeCustomRepository {
}
