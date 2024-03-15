package com.capstone.dayj.setting;


import com.capstone.dayj.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nickname;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private AppUser appUser;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean planAlarm;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean friendGroupAlarm;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean postAlarm;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean appAlarm;

    @Column(nullable = false)
    private String profilePhoto;


}
