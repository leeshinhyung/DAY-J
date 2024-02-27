package com.capstone.projectname.post;

import com.capstone.projectname.appUser.AppUser;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {
    PostService postService;
    
    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @PostMapping("/post/create")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post savedPost = postService.createPost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
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
