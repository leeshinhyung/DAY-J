package com.capstone.dayj.appUser;

import com.capstone.dayj.plan.Plan;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {
    AppUserService appUserService;
    
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    
    @PostMapping("/appUser/create")
    public void createAppUser(@Valid @RequestBody AppUser appUser) {
        appUserService.createAppUser(appUser);
    }
    
    @GetMapping("/appUser/read")
    public List<AppUser> readAllAppUser() {
        return appUserService.readAllAppUser();
    }
    
    @GetMapping("/appUser/read/{id}")
    public AppUser readAppUserById(@PathVariable int id) {
        return appUserService.readAppUserById(id);
    }
    
    @GetMapping("/appUser/read/{id}/plan")
    public List<Plan> readPlanForAppUser(@PathVariable int id) {
        AppUser appUser = appUserService.readAppUserById(id);
        return appUser.getPlans();
    }
    
    @GetMapping("/appUser/update/{id}")
    public AppUser updateAppUserView(@PathVariable int id) {
        return appUserService.readAppUserById(id);
    }
    
    @PatchMapping("/appUser/update/{id}")
    public void patchAppUser(@Valid @RequestBody AppUser appUser) {
        appUserService.updateAppUser(appUser);
    }
    
    @DeleteMapping("/appUser/delete/{id}")
    public void deleteAppUserById(@PathVariable int id) {
        appUserService.deleteAppUserById(id);
    }
}