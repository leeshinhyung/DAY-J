package com.capstone.dayj.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    PostService postService;
    
    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @PostMapping("/post/create")
    public void createPost(@Valid @RequestBody Post post) {
        postService.createPost(post);
    }
    
    @GetMapping("/post/read")
    public List<Post> readAllPost() {
        return postService.readAllPost();
    }
    
    @GetMapping("/post/read/{id}")
    public Post readPostById(@PathVariable int id) {
        return postService.readPostById(id);
    }
    
    @GetMapping("/post/update/{id}")
    public Post updatePostView(@PathVariable int id) {
        return postService.readPostById(id);
    }
    
    @PatchMapping("/post/update/{id}")
    public void patchPost(@Valid @RequestBody Post post) {
        postService.updatePost(post);
    }
    
    @DeleteMapping("/post/delete/{id}")
    public void deletePostById(@PathVariable int id) {
        postService.deletePostById(id);
    }
}
