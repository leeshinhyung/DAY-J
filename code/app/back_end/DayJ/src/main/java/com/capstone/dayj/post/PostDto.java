package com.capstone.dayj.post;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.comment.Comment;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class PostDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private int id;
        private String postTitle;
        private String postContent;
        private String postTag;
        private boolean postIsAnonymous;
        private String postPhoto;
        private AppUser appUser;

        public Post toEntity() {
            return Post.builder()
                    .id(id)
                    .postTitle(postTitle)
                    .postContent(postContent)
                    .postTag(postTag)
                    .postIsAnonymous(postIsAnonymous)
                    .postPhoto(postPhoto)
                    .appUser(appUser)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final int id;
        private final int postView;
        private final int postLike;
        private final String postTitle;
        private final String postContent;
        private final String postTag;
        private final LocalDate postDate;
        private final boolean postIsAnonymous;
        private final String postPhoto;
        private final AppUser appUser;
        private final List<Comment> comment;

        public Response(Post post) {
            this.id = post.getId();
            this.postView = post.getPostView();
            this.postLike = post.getPostLike();
            this.postTitle = post.getPostTitle();
            this.postContent = post.getPostContent();
            this.postTag = post.getPostTag();
            this.postDate = post.getPostDate();
            this.postIsAnonymous = post.isPostIsAnonymous();
            this.postPhoto = post.getPostPhoto();
            this.appUser = post.getAppUser();
            this.comment = post.getComment(); //수정 필요
        }

    }
}
