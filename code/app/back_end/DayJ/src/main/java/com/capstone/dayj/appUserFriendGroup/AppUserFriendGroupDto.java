package com.capstone.dayj.appUserFriendGroup;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.friendGroup.FriendGroup;
import lombok.*;

public class AppUserFriendGroupDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id;
        private AppUser appUser;
        private FriendGroup friendGroup;
        
        public AppUserFriendGroup toEntity() {
            return AppUserFriendGroup.builder()
                    .id(id)
                    .appUser(appUser)
                    .friendGroup(friendGroup)
                    .build();
        }
    }
    
    @Getter
    public static class Response {
        private final int id;
        private final AppUser appUser;
        private final FriendGroup friendGroup;
        
        public Response(AppUserFriendGroup appUserFriendGroup) {
            this.id = appUserFriendGroup.getId();
            this.appUser = appUserFriendGroup.getAppUser();
            this.friendGroup = appUserFriendGroup.getFriendGroup();
        }
        
    }
}
