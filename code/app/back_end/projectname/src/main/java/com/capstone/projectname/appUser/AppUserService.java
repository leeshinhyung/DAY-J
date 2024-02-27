package com.capstone.projectname.appUser;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class AppUserService {
    private static List<AppUser> appUsers = new ArrayList<>();
    private static int appUsersCount = 0;
    
    static {
        appUsers.add(new AppUser(++appUsersCount, "name", "umm", true, true, true, true, "what"));
        appUsers.add(new AppUser(++appUsersCount, "name", "sdlkjwe", true, true, true, true, "what"));
        appUsers.add(new AppUser(++appUsersCount, "name", "wdferlkasd", true, true, true, true, "what"));
    }
    
    public AppUser createUser(AppUser user) {
        user.setId(++appUsersCount);
        appUsers.add(user);
        return user;
    }
    
    public List<AppUser> readAllUser() {
        return appUsers;
    }
    
    public AppUser readUserById(int id) {
        Predicate<? super AppUser> predicate = appUser -> appUser.getId() == id;
        return appUsers.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public void updateUser(AppUser appUser) {
        Predicate<? super AppUser> predicate = user -> user.getId() == appUser.getId();
        AppUser prevAppUser = appUsers.stream().filter(predicate).findFirst().orElse(null);
        appUsers.remove(prevAppUser);
        appUsers.add(appUser);
    }
    
    public void deleteUserById(int id) {
        Predicate<? super AppUser> predicate = appUser -> appUser.getId() == id;
        appUsers.removeIf(predicate);
    }
}
