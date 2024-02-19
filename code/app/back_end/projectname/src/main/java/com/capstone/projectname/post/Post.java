package com.capstone.projectname.post;

//Table plan {
//	  is_complete boolean
//	  plan_id integer [primary key]
//	  plan_alarm_date date
//	  plan_tag varchar
//	  plan_create_date date
//	  goal varchar // 세부 목표
//	}

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private int postView;
	private int postLike;
	
	@Column(nullable = false)
	private String postContent;
	private String postName;
	private String postTag;
	private String postComment;
	
	@Column(nullable = false)
	private Date postDate;
	private Date postCommentDate;
	
}
