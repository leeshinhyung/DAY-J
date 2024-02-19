package com.capstone.projectname.fgroup;

import jakarta.persistence.*;

@Entity
public class FGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int groupId;
	
	@Column(nullable = false)
	private String groupName;
}
