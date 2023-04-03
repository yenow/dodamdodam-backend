package com.ysy.dodamdodam.domain.user.repository;

import com.ysy.dodamdodam.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

}
