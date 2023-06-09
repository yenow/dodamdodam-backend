package com.ysy.dodamdodam.domain.user.repository;

import com.ysy.dodamdodam.domain.user.entity.Gender;
import com.ysy.dodamdodam.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findUsers() {
        List<User> all = userRepository.findAll();
        log.info("all : {}",all);
    }

    @Test
    @Transactional
    void saveUser() {
        User user = User.builder()
                .nickname("TestNickname")
                .birthDay("19941129")
                .email("test@google.com")
                .gender(Gender.man)
                .build();

        User saveUser = userRepository.save(user);
        log.info("saveUser : {}", saveUser);

        Optional<User> optionalUser = userRepository.findById(saveUser.getUserId());
        User findUser = optionalUser.orElse(User.builder().build());
        log.info("findUser : {}", findUser);

        User findUserTest = userRepository.findByIdForTest(saveUser.getUserId());
        log.info("findUserTest : {}", findUserTest);

    }
}