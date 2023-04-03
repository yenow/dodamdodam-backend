package com.ysy.dodamdodam.domain.post.entity;

import com.ysy.dodamdodam.domain.user.entity.User;
import com.ysy.dodamdodam.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Comment("제목")
    @Column(length = 300)
    private String title;
    @Comment("내용")
    @Column(length = 4000, nullable = false)
    private String content;
    @Comment("작성자")
    @Column(length = 200)
    private String author;
    @Comment("배경이미지")
    @Column(length = 200)
    private String backgroundImageName;
    @Comment("조회수")
    @Builder.Default
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer clickCount = 0;
    @Comment("삭제여부")
    @Builder.Default
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isDeleted = false;
    @Comment("신고여부")
    @Builder.Default
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isReported = false;

    public void increaseClickCount() {
        clickCount = clickCount + 1;
    }

    public void deletePost() { isDeleted = true; }

    public void reportPost() { isReported = true; }

}
