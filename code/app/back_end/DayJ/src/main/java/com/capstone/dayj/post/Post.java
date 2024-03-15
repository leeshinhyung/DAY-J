package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    private AppUser appUser;

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
}
