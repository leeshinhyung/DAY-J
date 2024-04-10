package com.capstone.dayj.comment;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.appUser.AppUserNotFoundException;
import com.capstone.dayj.appUser.AppUserRepository;
import com.capstone.dayj.appUser.AppUserService;
import com.capstone.dayj.post.Post;
import com.capstone.dayj.post.PostNotFoundException;
import com.capstone.dayj.post.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .orElseThrow(() -> new AppUserNotFoundException("해당 id를 가진 사용자가 없습니다."));
        Post post = postRepository.findById(postId)
                        .orElseThrow(() -> new PostNotFoundException("해당 게시물이 존재하지 않습니다."));

        dto.setAppUser(user);
        dto.setPost(post);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);
    }
    @Transactional
    public List<CommentDto.Response> readAllComment(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 게시물이 존재하지 않습니다."));
        List<Comment> comments = post.getComment();
        return comments.stream().map(CommentDto.Response::new).collect(Collectors.toList());
    }

    @Transactional
    public CommentDto.Response readCommentById(int postId, int commentId){
        Comment comment = commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글이 존재하지 않습니다."));
        return new CommentDto.Response(comment);
    }
    @Transactional
    public void patchComment(int postId, int commentId, CommentDto.Request dto){
        Comment comment = commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글이 존재하지 않습니다."));

        comment.update(dto.getContent(), dto.isCommentIsAnonymous());
    } // 작성자 본인만 수정 가능

    @Transactional
    public void deleteCommentById(int postId, int commentId){
        Comment comment = commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글이 존재하지 않습니다."));

        commentRepository.delete(comment);
    } // 작성자 본인만 삭제 가능
}
