package com.capstone.projectname.friendGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FriendGroup {
    
    @Id
    @Column(nullable = false)
    private int groupId;
    
    @Column(nullable = false)
    private String groupName;
}
