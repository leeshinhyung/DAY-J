package com.capstone.projectname.plan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Plan {

    @Id
    @Column(nullable = false)
    private int planId;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean isComplete;

    @Column(nullable = false)
    private Date planAlarmDate;
    private Date planCreateDate;
    
    @Column(nullable = false)
    private String planTag;
    private String goal;

    @Column(nullable = true)
    private String planPhoto;

    @Column(nullable = false)
    private Time planTime;

    @Column(nullable = false)
    private Date planDay;


    public Plan() {
    }

    public Plan(int planId, boolean isComplete, Date planAlarmDate, Date planCreateDate, String planTag, String goal, String planPhoto, Time planTime, Date planDay) {
        this.planId = planId;
        this.isComplete = isComplete;
        this.planAlarmDate = planAlarmDate;
        this.planCreateDate = planCreateDate;
        this.planTag = planTag;
        this.goal = goal;
        this.planPhoto = planPhoto;
        this.planTime = planTime;
        this.planDay = planDay;

    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Date getPlanAlarmDate() {
        return planAlarmDate;
    }

    public void setPlanAlarmDate(Date planAlarmDate) {
        this.planAlarmDate = planAlarmDate;
    }

    public Date getPlanCreateDate() {
        return planCreateDate;
    }

    public void setPlanCreateDate(Date planCreateDate) {
        this.planCreateDate = planCreateDate;
    }

    public String getPlanTag() {
        return planTag;
    }

    public void setPlanTag(String planTag) {
        this.planTag = planTag;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getPlanPhoto() {
        return planPhoto;
    }

    public void setPlanPhoto(String planPhoto) {
        this.planPhoto = planPhoto;
    }

    public Time getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Time planTime) {
        this.planTime = planTime;
    }
    public Date getPlanDay() {
        return planDay;
    }

    public void setPlanDay(Date planDay) {
        this.planDay = planDay;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planId=" + planId +
                ", isComplete=" + isComplete +
                ", planAlarmDate=" + planAlarmDate +
                ", planCreateDate=" + planCreateDate +
                ", planTag='" + planTag + '\'' +
                ", goal='" + goal + '\'' +
                ", planPhoto='" + planPhoto + '\'' +
                ", planTime=" + planTime +
                ", planDay=" + planDay +
                '}';
    }
}

