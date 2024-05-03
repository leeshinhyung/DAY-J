package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{user_id}")
    public void createPost(@PathVariable int user_id, @Valid @RequestBody PostDto.Request dto) {
        postService.createPost(dto, user_id);
    }

    @GetMapping
    public List<Post> readAllPost() {
        return postService.readAllPost();
    }

//    @GetMapping
//    public List<PostDto.Response> readAllPost() {
//        return postService.readAllPost();
//    }

    @GetMapping("/{id}")
    public PostDto.Response readPostById(@PathVariable int id) {
        return postService.readPostById(id);
    }

    @PatchMapping("/{id}")
    public void patchPost(@PathVariable int id, @Valid @RequestBody PostDto.Request post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable int id) {
        postService.deletePostById(id);
    }
}
