package com.capstone.projectname.appUser;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {
    AppUserRepository appUserRepository;
    
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    
    @GetMapping("/find-appUser")
    public List<AppUser> returnTest() {
        return appUserRepository.findAll();
    }
    
    @GetMapping("/find-appUser-id")
    public AppUser findById() {
        return appUserRepository.findById(1).get();
    }
    
    @PostMapping("/update-appUser")
    public void update(@Valid @RequestBody AppUser appUser) {
        AppUser savedAppUser = appUserRepository.save(appUser);
    }
    
    @GetMapping("/delete-appUser-id")
    public void deleteById() {
        appUserRepository.deleteById(1);
    }
}
