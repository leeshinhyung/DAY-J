package com.capstone.dayj.appUser;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import com.capstone.dayj.plan.Plan;
import com.capstone.dayj.post.Post;
import com.capstone.dayj.setting.Setting;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String password;
    
    @OneToMany(mappedBy = "appUser")
    @JsonManagedReference
    @JsonIgnore
    private List<AppUserFriendGroup> appUserFriendGroup;
    
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<Plan> plans;
    
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<Post> posts;
    
    @OneToOne(mappedBy = "appUser")
    @JsonIgnore
    private Setting setting;
}

    

