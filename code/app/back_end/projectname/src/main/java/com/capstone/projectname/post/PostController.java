package com.capstone.projectname.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    PostRepository postRepository;
    
    
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    @GetMapping("/test-post")
    public List<Post> returnTest() {
        List<Post> post = postRepository.findAll();
        return post;
    }
}
