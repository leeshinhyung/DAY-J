package com.capstone.dayj.comment;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String content;
    private LocalDateTime commentDate;

    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean commentIsAnonymous;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    @JsonIgnore
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @JsonIgnore
    private Post post;

    @Builder
    public Comment(int id, String content, LocalDateTime commentDate, boolean commentIsAnonymous, AppUser appUser, Post post) {
        this.id = id;
        this.content = content;
        this.commentDate = commentDate;
        this.commentIsAnonymous = commentIsAnonymous;
        this.appUser = appUser;
        this.post = post;
    }
    public void update(String content, boolean commentIsAnonymous){
        this.content = content;
        this.commentIsAnonymous = commentIsAnonymous;
    }
}
