package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
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

    public void update(String postTitle, String postContent, String postTag, boolean postIsAnonymous, String postPhoto){
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTag = postTag;
        this.postIsAnonymous = postIsAnonymous;
        this.postPhoto = postPhoto;
    }
}
