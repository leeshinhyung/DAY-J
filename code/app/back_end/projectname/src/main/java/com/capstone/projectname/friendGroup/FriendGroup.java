package com.capstone.projectname.friendGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class FriendGroup {
    
    @Id
    @Column(nullable = false)
    private int groupId;
    
    @Column(nullable = false)
    private String groupName;

	@Column
	private String groupGoal;

	@Column(nullable = false)
	@ColumnDefault("1")
	private boolean groupExit;

    public FriendGroup() {
    	
    }

	public FriendGroup(int groupId, String groupName, String groupGoal, boolean groupExit) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupGoal = groupGoal;
		this.groupExit = groupExit;
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

	public String getGroupGoal() {
		return groupGoal;
	}

	public void setGroupGoal(String groupGoal) {
		this.groupGoal = groupGoal;
	}

	public boolean isGroupExit() {
		return groupExit;
	}

	public void setGroupExit(boolean groupExit) {
		this.groupExit = groupExit;
	}

	@Override
	public String toString() {
		return "FriendGroup{" +
				"groupId=" + groupId +
				", groupName='" + groupName + '\'' +
				", groupGoal='" + groupGoal + '\'' +
				", groupExit=" + groupExit +
				'}';
	}
}
