package com.capstone.dayj.appUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/private/app-user")
public class AppUserController {
    AppUserService appUserService;
    
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping
    public void createAppUser(@Valid @RequestBody AppUser appUser) {
        appUserService.createAppUser(appUser);
    }
    
    @GetMapping
    public List<AppUser> readAllAppUser() {
        return appUserService.readAllAppUser();
    }
    
    @GetMapping("/{id}")
    public Optional<AppUser> readAppUserById(@PathVariable int id) {
        return appUserService.readAppUserById(id);
   }

    @PatchMapping("/{id}")
    public void patchAppUser(@PathVariable int id, @Valid @RequestBody AppUser appUser) {
        appUserService.updateAppUser(appUser, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppUserById(@PathVariable int id) {
        appUserService.deleteAppUserById(id);
    }

}