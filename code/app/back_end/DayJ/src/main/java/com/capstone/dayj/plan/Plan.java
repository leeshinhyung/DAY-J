package com.capstone.dayj.plan;

import com.capstone.dayj.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Data
public class Plan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private AppUser appUser;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean isComplete;
    
    @Column(nullable = false)
    private LocalDate planAlarmDate;
    @Column(nullable = false)
    private LocalDate planCreateDate;
    
    @Column(nullable = false)
    private String planTag;
    @Column(nullable = false)
    private String goal;
    
    @Column(nullable = true)
    private String planPhoto;
    
    @Column(nullable = false)
    private LocalDate planTime;
    
    @Column(nullable = false)
    private LocalDate planDay;
}

