package com.capstone.projectname.post;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int postView;
    private int postLike;
    
    @Column(nullable = false)
    private String postContent;
    private String postName;
    private String postTag;
    private String postComment;
    
    @Column(nullable = false)
    private LocalDate postDate;
    private LocalDate postCommentDate;

    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean postIsAnonymous;
    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean commentIsAnonymous;

    @Column(nullable = false)
    private String postPhoto;

    public Post() {
    }

    public Post(int id, int postView, int postLike, String postContent, String postName, String postTag, String postComment, LocalDate postDate, LocalDate postCommentDate, boolean postIsAnonymous, boolean commentIsAnonymous, String postPhoto) {
        this.id = id;
        this.postView = postView;
        this.postLike = postLike;
        this.postContent = postContent;
        this.postName = postName;
        this.postTag = postTag;
        this.postComment = postComment;
        this.postDate = postDate;
        this.postCommentDate = postCommentDate;
        this.postIsAnonymous = postIsAnonymous;
        this.commentIsAnonymous = commentIsAnonymous;
        this.postPhoto = postPhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostView() {
        return postView;
    }

    public void setPostView(int postView) {
        this.postView = postView;
    }

    public int getPostLike() {
        return postLike;
    }

    public void setPostLike(int postLike) {
        this.postLike = postLike;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostTag() { return postTag; }

    public void setPostTag(String postTag) {
        this.postTag = postTag;
    }

    public String getPostComment() {
        return postComment;
    }

    public void setPostComment(String postComment) {
        this.postComment = postComment;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public LocalDate getPostCommentDate() {
        return postCommentDate;
    }

    public void setPostCommentDate(LocalDate postCommentDate) {
        this.postCommentDate = postCommentDate;
    }

    public boolean isPostIsAnonymous() {
        return postIsAnonymous;
    }

    public void setPostIsAnonymous(boolean postIsAnonymous) {
        this.postIsAnonymous = postIsAnonymous;
    }

    public boolean isCommentIsAnonymous() {
        return commentIsAnonymous;
    }

    public void setCommentIsAnonymous(boolean commentIsAnonymous) {
        this.commentIsAnonymous = commentIsAnonymous;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(String postPhoto) {
        this.postPhoto = postPhoto;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postView=" + postView +
                ", postLike=" + postLike +
                ", postContent='" + postContent + '\'' +
                ", postName='" + postName + '\'' +
                ", postTag='" + postTag + '\'' +
                ", postComment='" + postComment + '\'' +
                ", postDate=" + postDate +
                ", postCommentDate=" + postCommentDate +
                ", postIsAnonymous=" + postIsAnonymous +
                ", commentIsAnonymous=" + commentIsAnonymous +
                ", postPhoto='" + postPhoto + '\'' +
                '}';
    }
}
