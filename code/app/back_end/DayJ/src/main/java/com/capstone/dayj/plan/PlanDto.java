package com.capstone.dayj.plan;

import com.capstone.dayj.appUser.AppUser;
import lombok.*;

import java.time.LocalDate;

public class PlanDto {
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id;
        private AppUser appUser;
        private boolean isComplete;
        private LocalDate planAlarmDate;
        private LocalDate planCreateDate;
        private String planTag;
        private String goal;
        private String planPhoto;
        private LocalDate planTime;
        private LocalDate planDay;
        private boolean isPublic;
        
        public Plan toEntity() {
            return Plan.builder()
                    .id(id)
                    .appUser(appUser)
                    .isComplete(isComplete)
                    .planAlarmDate(planAlarmDate)
                    .planCreateDate(planCreateDate)
                    .planTag(planTag)
                    .goal(goal)
                    .planPhoto(planPhoto)
                    .planTime(planTime)
                    .planDay(planDay)
                    .isPublic(isPublic)
                    .build();
        }
    }
    
    @Getter
    public static class Response {
        private final int id;
        private final AppUser appUser;
        private final boolean isComplete;
        private final LocalDate planAlarmDate;
        private final LocalDate planCreateDate;
        private final String planTag;
        private final String goal;
        private final String planPhoto;
        private final LocalDate planTime;
        private final LocalDate planDay;
        private final boolean isPublic;
        
        /* Entity -> Dto */
        public Response(Plan plan) {
            this.id = plan.getId();
            this.appUser = plan.getAppUser();
            this.isComplete = plan.isComplete();
            this.planAlarmDate = plan.getPlanAlarmDate();
            this.planCreateDate = plan.getPlanCreateDate();
            this.planTag = plan.getPlanTag();
            this.goal = plan.getGoal();
            this.planPhoto = plan.getPlanPhoto();
            this.planTime = plan.getPlanTime();
            this.planDay = plan.getPlanDay();
            this.isPublic = plan.isPublic();
        }
    }
}
