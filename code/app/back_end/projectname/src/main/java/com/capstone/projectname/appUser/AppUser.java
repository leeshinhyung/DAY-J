package com.capstone.projectname.appUser;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nickname;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean friendGroupAlarm;
    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean planAlarm;
    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean postAlarm;
    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean appAlarm;
    
    @Column(nullable = false)
    private String profilePhoto;
}

    

