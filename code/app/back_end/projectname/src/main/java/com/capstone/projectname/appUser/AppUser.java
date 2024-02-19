package com.capstone.projectname.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
public class AppUser {
    @Id
    private int id;
    
    private String nickname;
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean alarmOnOff;
    
    @Column(nullable = false)
    private LocalDate alarmDate;
    
    private String profilePhotoPath;
    
    public AppUser() {
    
    }
    
    public AppUser(int id, String password, String nickname, boolean alarmOnOff, LocalDate alarmDate, String profilePhotoPath) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.alarmOnOff = alarmOnOff;
        this.alarmDate = alarmDate;
        this.profilePhotoPath = profilePhotoPath;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public boolean isAlarmOnOff() {
        return alarmOnOff;
    }
    
    public void setAlarmOnOff(boolean alarmOnOff) {
        this.alarmOnOff = alarmOnOff;
    }
    
    public LocalDate getAlarmDate() {
        return alarmDate;
    }
    
    public void setAlarmDate(LocalDate alarmDate) {
        this.alarmDate = alarmDate;
    }
    
    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }
    
    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }
    
    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", alarmOnOff=" + alarmOnOff +
                ", alarmDate=" + alarmDate +
                ", profilePhotoPath='" + profilePhotoPath + '\'' +
                '}';
    }
}
