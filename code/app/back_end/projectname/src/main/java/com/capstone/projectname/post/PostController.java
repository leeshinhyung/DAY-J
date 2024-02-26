package com.capstone.projectname.post;

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
    
    @GetMapping("/find-post")
    public List<Post> findAll() {
        return postService.findAll();
    }
    
    @GetMapping("/find-post/{id}")
    public Post findById() {
        return postService.findOne(1);
    }
    
    @PostMapping("/create-post")
    public ResponseEntity<Post> create(@Valid @RequestBody Post post) {
        Post savedPost = postService.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete-post/{id}")
    public void deleteById() {
        postService.deleteById(1);
    }
}
