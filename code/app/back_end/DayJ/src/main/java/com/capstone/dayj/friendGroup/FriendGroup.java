package com.capstone.dayj.friendGroup;

import com.capstone.dayj.appUser.AppUser;
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
    
//    @ManyToMany(mappedBy = "groups")
//	private List<AppUser> appUsers;

	@Column
	private String groupGoal;

	@Column
	private String groupName;

	@Column(nullable = false)
	@ColumnDefault("0")
	private boolean groupExit;
}
