package com.capstone.projectname.post;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Data
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
}
