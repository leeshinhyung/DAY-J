package com.capstone.dayj.plan;

import com.capstone.dayj.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    @JsonIgnore
    private AppUser appUser;
    
    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean isComplete;
    
    @Column(nullable = false)
    private LocalDate planAlarmDate;
    @Column(nullable = false)
    private LocalDate planCreateDate;
    
    @Column(nullable = false)
    private String planTag;
    @Column(nullable = false)
    private String goal;
    
    private String planPhoto;
    
    @Column(nullable = false)
    private LocalDate planTime;
    
    @Column(nullable = false)
    private LocalDate planDay;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean isPublic;
    
    public void update(LocalDate planAlarmDate, String planTag, String goal, String planPhoto, LocalDate planTime, LocalDate planDay) {
        this.planAlarmDate = planAlarmDate;
        this.planTag = planTag;
        this.goal = goal;
        this.planPhoto = planPhoto;
        this.planTime = planTime;
        this.planDay = planDay;
    }
}

