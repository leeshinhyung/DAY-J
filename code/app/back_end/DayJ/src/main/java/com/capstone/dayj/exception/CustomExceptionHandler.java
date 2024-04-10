package com.capstone.dayj.exception;

import com.capstone.dayj.appUser.AppUserNotFoundException;
import com.capstone.dayj.friendGroup.FriendGroupNotFoundException;
import com.capstone.dayj.plan.PlanNotFoundException;
import com.capstone.dayj.post.PostNotFoundException;
import com.capstone.dayj.post.PostUnauthorizedException;
import com.capstone.dayj.comment.CommentNotFoundException;
import com.capstone.dayj.comment.CommentUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FriendGroupNotFoundException.class)
    protected ResponseEntity<?> handleFriendGroupNotFoundException(FriendGroupNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
    @ExceptionHandler(PlanNotFoundException.class)
    protected ResponseEntity<?> handlePlanNotFoundException(PlanNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AppUserNotFoundException.class)
    protected ResponseEntity<?> handleAppUserNotFoundException(AppUserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    protected ResponseEntity<?> handleCommentNotFoundException(CommentNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(PostNotFoundException.class)
    protected ResponseEntity<?> handlePostNotFoundException(PostNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CommentUnauthorizedException.class)
    protected ResponseEntity<?> handleCommentUnauthorizedException(CommentUnauthorizedException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(PostUnauthorizedException.class)
    protected ResponseEntity<?> handlePostUnauthorizedException(PostUnauthorizedException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}