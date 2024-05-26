package com.capstone.dayj.appUserFriendGroup;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.friendGroup.FriendGroup;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"appUser"})
public class AppUserFriendGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    @JsonBackReference
    @JsonIgnore
    private AppUser appUser;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_group_id", referencedColumnName = "id")
    @JsonBackReference
    @JsonIgnore
    private FriendGroup friendGroup;
    
    @Builder
    public AppUserFriendGroup(int id, AppUser appUser, FriendGroup friendGroup) {
        this.id = id;
        this.appUser = appUser;
        this.friendGroup = friendGroup;
    }
}
