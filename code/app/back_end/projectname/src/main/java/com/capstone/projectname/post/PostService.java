package com.capstone.projectname.post;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class PostService {
    private PostRepository postRepository;
    
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    
    public void createPost(Post user) {
        postRepository.save(user);
    }
    
    public List<Post> readAllPost() {
        return postRepository.findAll();
    }
    
    public Post readPostById(int id) {
        return postRepository.findById(id).get();
    }
    
    public void updatePost(Post post) {
        postRepository.save(post);
    }
    
    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }
}
