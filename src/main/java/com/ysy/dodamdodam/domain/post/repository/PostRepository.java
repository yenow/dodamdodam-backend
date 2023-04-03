package com.ysy.dodamdodam.domain.post.repository;

import com.ysy.dodamdodam.domain.post.entity.Post;
import com.ysy.dodamdodam.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {
}
