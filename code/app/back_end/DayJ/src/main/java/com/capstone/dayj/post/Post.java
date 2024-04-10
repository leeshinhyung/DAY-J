package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int postView;
    private int postLike;
    
    @Column(nullable = false)
    private String postTitle;
    private String postContent;
    private String postTag;
    
    @Column(nullable = false)
    private LocalDate postDate;

    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean postIsAnonymous;

    @Column(nullable = false)
    private String postPhoto;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Comment> comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    @JsonIgnore
    private AppUser appUser;

    @Builder
    public Post(int id, int postView, int postLike, String postTitle, String postContent, String postTag, LocalDate postDate, boolean postIsAnonymous, String postPhoto, List<Comment> comment, AppUser appUser) {
        this.id = id;
        this.postView = postView;
        this.postLike = postLike;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTag = postTag;
        this.postDate = postDate;
        this.postIsAnonymous = postIsAnonymous;
        this.postPhoto = postPhoto;
        this.comment = comment;
        this.appUser = appUser;
    }

    public void update(String postTitle, String postContent, String postTag, boolean postIsAnonymous, String postPhoto){
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTag = postTag;
        this.postIsAnonymous = postIsAnonymous;
        this.postPhoto = postPhoto;
    }
}
