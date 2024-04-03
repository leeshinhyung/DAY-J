package com.capstone.dayj.friendGroup;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Data
public class FriendGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "friendGroup")
    @JsonIgnore
    private List<AppUserFriendGroup> appUserFriendGroups;
    
    @Column
    private String groupGoal;
    
    @Column(nullable = false)
    private String groupName;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean groupExit;
}
