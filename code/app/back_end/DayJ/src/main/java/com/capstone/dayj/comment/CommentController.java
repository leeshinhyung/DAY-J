package com.capstone.dayj.comment;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.post.Post;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{app_user_id}/{post_id}/comment")
    public void createComment(@PathVariable int app_user_id, @PathVariable int post_id, @Valid @RequestBody CommentDto.Request dto){
        commentService.createComment(app_user_id, post_id, dto);
    }

    @GetMapping("/{app_user_id}/{post_id}/comment")
    public List<CommentDto.Response> readAllComment(@PathVariable int app_user_id, @PathVariable int post_id){
        return commentService.readAllComment(app_user_id, post_id);
    }

    @GetMapping("/{post_id}/comment/{comment_id}")
    public CommentDto.Response readCommentById(@PathVariable int post_id, @PathVariable int comment_id){
        return commentService.readCommentById(post_id, comment_id);
    }

    @PatchMapping("/{post_id}/comment/{comment_id}")
    public void patchComment(@PathVariable int post_id, @PathVariable int comment_id, @Valid @RequestBody CommentDto.Request dto){
        commentService.patchComment(post_id, comment_id, dto);
    }

    @DeleteMapping("/{post_id}/comment/{comment_id}")
    public void deleteCommentById(@PathVariable int post_id, @PathVariable int comment_id){
        commentService.deleteCommentById(post_id, comment_id);
    }
}
