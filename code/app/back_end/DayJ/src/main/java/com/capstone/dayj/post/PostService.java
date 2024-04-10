package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.appUser.AppUserNotFoundException;
import com.capstone.dayj.appUser.AppUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AppUserRepository appUserRepository;

    @Transactional
    public void createPost(PostDto.Request dto, int userId) {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new AppUserNotFoundException("해당 id를 가진 사용자가 없습니다."));
        dto.setAppUser(appUser);
        Post post = dto.toEntity();

        postRepository.save(post);
    }
    
    public List<Post> readAllPost() {
        return postRepository.findAll();
    } // 페이징 처리 필요함

    @Transactional
    public PostDto.Response readPostById(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new PostNotFoundException("해당 게시물이 존재하지 않습니다."));

        return new PostDto.Response(post);
    }

    @Transactional
    public void updatePost(int postId, PostDto.Request dto) {
        Post post = postRepository.findById(postId)
                        .orElseThrow(()-> new PostNotFoundException("해당 게시물이 존재하지 않습니다."));

        post.update(dto.getPostTitle(), dto.getPostContent(), dto.getPostTag(), dto.isPostIsAnonymous(), dto.getPostTag());


//        AppUser user = appUserRepository.findById(userId)
//                .orElseThrow(() -> new AppUserNotFoundException("해당 id를 가진 사용자가 없습니다."));;
//
//        String userName = user.getName();
//        String postUserName = newPost.getAppUser().getName();
//
//        if(userName.equals(postUserName)){
//
//            newPost.setPostContent(post.getPostContent());
//            postRepository.save(newPost);
//        }
//        else throw new PostUnauthorizedException("게시물을 수정할 수 있는 권한이 없습니다.");
    }

    @Transactional
    public void deletePostById(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 게시물이 존재하지 않습니다."));

        postRepository.delete(post);


//        Optional<AppUser> user = appUserService.readAppUserById(userId);
//        String userName = user.get().getName();
//        String postUserName = newPost.getAppUser().getName();
//
//        if(userName.equals(postUserName)){
//            postRepository.deleteById(postId);
//        }
//        else throw new PostUnauthorizedException("게시물을 수정할 수 있는 권한이 없습니다.");
    }
}
