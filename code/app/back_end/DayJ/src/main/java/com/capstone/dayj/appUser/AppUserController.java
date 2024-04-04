package com.capstone.dayj.appUser;
import com.capstone.dayj.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public AppUser readAppUserById(@PathVariable int id) {
        return appUserService.readAppUserById(id).orElseThrow(() -> new NotFoundException("Could not found user for " + id));
   }

    @PatchMapping("/{id}")
    public void patchAppUser(@PathVariable int id, @Valid @RequestBody AppUser appUser) {
        appUserService.updateAppUser(appUser, id);
    }
    // 구글 자동로그인 & 회원가입할건데 필요없지 않나 ???

    @DeleteMapping("/{id}")
    public void deleteAppUserById(@PathVariable int id) {
        appUserService.deleteAppUserById(id);
    }

}