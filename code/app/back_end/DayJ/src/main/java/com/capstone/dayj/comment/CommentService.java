package com.capstone.dayj.comment;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.appUser.AppUserRepository;
import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import com.capstone.dayj.post.Post;
import com.capstone.dayj.post.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final AppUserRepository appUserRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createComment (int userId, int postId, CommentDto.Request dto) {
        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new CustomException(ErrorCode.POST_NOT_FOUND));

        dto.setAppUser(user);
        dto.setPost(post);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);
    }

    public List<CommentDto.Response> readAllComment(int postId, int userId) {
        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new CustomException(ErrorCode.POST_NOT_FOUND));


        List<Comment> comments = post.getComment();

        return comments.stream().map(CommentDto.Response::new).collect(Collectors.toList());
    }

    public CommentDto.Response readCommentById(int postId, int commentId){
        Comment comment = commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(()-> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

        return new CommentDto.Response(comment);
    }
    @Transactional
    public void patchComment(int postId, int commentId, CommentDto.Request dto){
        Comment comment = commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(()-> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

        comment.update(dto.getContent(), dto.isCommentIsAnonymous());
    } // 작성자 본인만 수정 가능

    @Transactional
    public void deleteCommentById(int postId, int commentId){
        Comment comment = commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(()-> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

        commentRepository.delete(comment);
    } // 작성자 본인만 삭제 가능
}
