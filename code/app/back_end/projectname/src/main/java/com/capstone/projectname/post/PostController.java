package com.capstone.projectname.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    PostRepository postRepository;
    
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    @GetMapping("/find-post")
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    
    @GetMapping("/find-post-id")
    public Post findById() {
        return postRepository.findById(1).get();
    }
    
    @PostMapping("/update-post")
    public void update(@Valid @RequestBody Post post) {
        Post savedPost = postRepository.save(post);
    }
    
    @GetMapping("/delete-post-id")
    public void deleteById() {
        postRepository.deleteById(1);
    }
}
