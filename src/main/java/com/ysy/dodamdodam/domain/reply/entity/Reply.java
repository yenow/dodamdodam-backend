package com.ysy.dodamdodam.domain.reply.entity;


import com.ysy.dodamdodam.domain.post.entity.Post;
import com.ysy.dodamdodam.domain.user.entity.User;
import com.ysy.dodamdodam.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "post"})
@DynamicInsert
@DynamicUpdate
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    @Column
    private Long parentReplyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Comment("댓글 작성자")
    @Column(length = 50)
    private String author;
    @Column
    private Long parentReplyUserId;
    @Column
    private String parentAuthor;
    @Comment("댓글 내용")
    @Column
    private String replyContent;
    @Comment("삭제 여부")
    @Builder.Default
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isDeleted = false;
    @Comment("신고 여부")
    @Builder.Default
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isReported = false;
}
