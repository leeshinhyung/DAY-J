package com.capstone.projectname.appUser;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AppUserController {
    AppUserService appUserService;
    
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    
    @PostMapping("/appUser/create")
    public ResponseEntity<AppUser> createAppUser(@Valid @RequestBody AppUser appUser) {
        AppUser savedAppUser = appUserService.createAppUser(appUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAppUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/appUser/read")
    public List<AppUser> readAllAppUser() {
        return appUserService.readAllAppUser();
    }
    
    @GetMapping("/appUser/read/{id}")
    public AppUser readAppUserById(@PathVariable int id) {
        return appUserService.readAppUserById(id);
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