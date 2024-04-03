package com.capstone.dayj.friendGroup;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class FriendGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "friendGroup")
    @JsonManagedReference
    @JsonIgnore
    private List<AppUserFriendGroup> appUserFriendGroup;
    
    @Column
    private String groupGoal;
    
    @Column(nullable = false)
    private String groupName;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean groupExit;
}
