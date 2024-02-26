package com.capstone.projectname.appUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class AppUser {
    @Id
    private int id;

    private String nickname;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @ColumnDefault("1")
    private boolean friendGroupAlarm;
    private boolean planAlarm;
    private boolean postAlarm;
    private boolean appAlarm;

    @Column(nullable = false)
    private String profilePhoto;

    public AppUser() {

    }

    public AppUser(int id, String nickname, String password, boolean friendGroupAlarm, boolean planAlarm, boolean postAlarm, boolean appAlarm,
                   String profilePhoto) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.friendGroupAlarm = friendGroupAlarm;
        this.planAlarm = planAlarm;
        this.postAlarm = postAlarm;
        this.appAlarm = appAlarm;
        this.profilePhoto = profilePhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFriendGroupAlarm() {
        return friendGroupAlarm;
    }

    public void setFriendGroupAlarm(boolean friendGroupAlarm) {
        this.friendGroupAlarm = friendGroupAlarm;
    }

    public boolean isPlanAlarm() {
        return planAlarm;
    }

    public void setPlanAlarm(boolean planAlarm) {
        this.planAlarm = planAlarm;
    }

    public boolean isPostAlarm() {
        return postAlarm;
    }

    public void setPostAlarm(boolean postAlarm) {
        this.postAlarm = postAlarm;
    }

    public boolean isAppAlarm() {
        return appAlarm;
    }

    public void setAppAlarm(boolean appAlarm) {
        this.appAlarm = appAlarm;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhotoPath(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", friendGroupAlarm=" + friendGroupAlarm +
                ", planAlarm=" + planAlarm +
                ", postAlarm=" + postAlarm +
                ", appAlarm=" + appAlarm +
                ", profilePhotoPath='" + profilePhoto + '\'' +
                '}';
    }
}

    

