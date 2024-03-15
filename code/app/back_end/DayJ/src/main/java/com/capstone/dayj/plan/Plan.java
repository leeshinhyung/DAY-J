package com.capstone.dayj.plan;

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

