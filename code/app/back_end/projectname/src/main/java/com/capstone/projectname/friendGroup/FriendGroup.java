package com.capstone.projectname.friendGroup;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class FriendGroup {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;
    
    @Column(nullable = false)
    private String groupName;

	@Column
	private String groupGoal;

	@Column(nullable = false)
	@ColumnDefault("0")
	private boolean groupExit;
}
