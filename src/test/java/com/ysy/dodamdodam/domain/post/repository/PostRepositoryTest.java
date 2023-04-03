package com.ysy.dodamdodam.domain.post.repository;

import com.ysy.dodamdodam.domain.post.entity.Post;
import com.ysy.dodamdodam.domain.user.entity.Gender;
import com.ysy.dodamdodam.domain.user.entity.User;
import com.ysy.dodamdodam.domain.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    void savePost() {
        User user = User.builder()
                .nickname("TestNickname")
                .birthDay("19941129")
                .email("test@google.com")
                .gender(Gender.man)
                .build();
        userRepository.save(user);

        Post post = Post.builder()
                .author("지은이")
                .content("내용입니다.")
                .user(user)
                .build();

        Post savePost = postRepository.save(post);

        entityManager.clear();

        Optional<Post> optionalPost = postRepository.findById(savePost.getPostId());
        Post findPost = optionalPost.orElse(Post.builder().build());
        log.info("findPost : {}", findPost);

        Long userId = findPost.getUser().getUserId();
        log.info("user of findPost : {}", findPost.getUser());
    }
}