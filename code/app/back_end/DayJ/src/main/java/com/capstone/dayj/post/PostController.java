package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @PostMapping
//    public void createPost(@Valid @RequestBody PostDto.Request request, AppUser appUser) {
//        postService.createPost(request, appUser.getId());
//    }

    @PostMapping
    public void createPost(@Valid @RequestBody PostDto.Request dto) {
        postService.createPost(dto);
    }
    
    @GetMapping
    public List<Post> readAllPost() {
        return postService.readAllPost();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity readPostById(@PathVariable int id) {
        return ResponseEntity.ok(postService.readPostById(id));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity patchPost(@PathVariable int id, @Valid @RequestBody PostDto.Request post) {
        postService.updatePost(id, post);
        return ResponseEntity.ok(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deletePostById(@PathVariable int id) {
        postService.deletePostById(id);
        return ResponseEntity.ok(id);
    }
}
