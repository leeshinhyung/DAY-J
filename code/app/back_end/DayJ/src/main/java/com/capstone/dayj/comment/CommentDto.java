package com.capstone.dayj.comment;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.post.Post;
import lombok.*;

import java.time.LocalDateTime;

public class CommentDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private int id;
        private String content;
        private boolean commentIsAnonymous;
        private LocalDateTime commentDate;
        private LocalDateTime commentUpdateDate;
        private AppUser appUser;
        private Post post;

        public Comment toEntity(){
            return Comment.builder()
                    .id(id)
                    .content(content)
                    .commentIsAnonymous(commentIsAnonymous)
                    .commentDate(commentDate)
                    .commentUpdateDate(commentUpdateDate)
                    .appUser(appUser)
                    .post(post)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final int id;
        private final String content;
        private final LocalDateTime commentDate;
        private final LocalDateTime commentUpdateDate;
        private final boolean commentIsAnonymous;
        private final AppUser appUser;
        private final Post post;

        public Response(Comment comment){
            this.id = comment.getId();
            this.content = comment.getContent();
            this.commentDate = comment.getCommentDate();
            this.commentUpdateDate = comment.getCommentUpdateDate();
            this.commentIsAnonymous = comment.isCommentIsAnonymous();
            this.appUser = comment.getAppUser();
            this.post = comment.getPost();
        }

    }
}
