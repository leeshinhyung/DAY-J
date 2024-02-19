package com.capstone.projectname.appUser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {
    AppUserRepository appUserRepository;
    
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    
    @GetMapping("/test-appUser")
    public List<AppUser> returnTestUser() {
        List<AppUser> appUsers = appUserRepository.findAll();
        return appUsers;
    }
}
