package com.capstone.dayj.comment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.capstone.dayj.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM Comment c, Post p WHERE  p.id= :postId AND c.id = :commentId")
    Optional<Comment> findByPostIdAndId(@Param("postId") int postId, @Param("commentId")int commentId);
}


