package com.capstone.projectname.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    
    @GetMapping("/delete-post-id")
    public void deleteById() {
        postRepository.deleteById(1);
    }
}
