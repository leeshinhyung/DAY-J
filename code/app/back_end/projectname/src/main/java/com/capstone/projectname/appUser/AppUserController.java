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
    public ResponseEntity<AppUser> create(@Valid @RequestBody AppUser appUser) {
        AppUser savedAppUser = appUserService.createUser(appUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAppUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/appUser/read")
    public List<AppUser> readAllUser() {
        return appUserService.readAllUser();
    }
    
    @GetMapping("/appUser/read/{id}")
    public AppUser readUserById(@PathVariable int id) {
        return appUserService.readUserById(id);
    }
    
    @GetMapping("/appUser/update/{id}")
    public AppUser updateUserView(@PathVariable int id) {
        return appUserService.readUserById(id);
    }
    
    @PatchMapping("/appUser/update/{id}")
    public void patchUser(@Valid @RequestBody AppUser appUser) {
        appUserService.updateUser(appUser);
    }
    
    @DeleteMapping("/appUser/delete/{id}")
    public void deleteUserById(@PathVariable int id) {
        appUserService.deleteUserById(id);
    }
}