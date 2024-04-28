package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUserRepository;
import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    
    private final PostRepository postRepository;
    private final AppUserRepository appUserRepository;

    @Transactional
    public void createPost(PostDto.Request dto, int userId) {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() ->new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        dto.setAppUser(appUser);
        Post post = dto.toEntity();
        
        postRepository.save(post);
    }
    
    public List<Post> readAllPost() {
        return postRepository.findAll();
    } // TODO 페이징 처리 필요함
    
    @Transactional
    public PostDto.Response readPostById(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        
        return new PostDto.Response(post);
    }
    
    @Transactional
    public void updatePost(int postId, PostDto.Request dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        
        post.update(dto.getPostTitle(), dto.getPostContent(), dto.getPostTag(), dto.isPostIsAnonymous(), dto.getPostTag());
    }
    
    @Transactional
    public void deletePostById(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        
        postRepository.deleteById(post.getId());
    }
}
