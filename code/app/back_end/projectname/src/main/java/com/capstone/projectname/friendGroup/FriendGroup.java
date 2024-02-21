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

    public FriendGroup() {
    	
    }
    
	public FriendGroup(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "FriendGroup [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
	// 인텔리제이에 맞춰서 수정 필요
    
    
}
