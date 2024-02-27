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
    
    @PostMapping("/create-appUser")
    public ResponseEntity<AppUser> create(@Valid @RequestBody AppUser appUser) {
        AppUser savedAppUser = appUserService.save(appUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAppUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/find-appUser")
    public List<AppUser> findAll() {
        return appUserService.findAll();
    }
    
    @GetMapping("/find-appUser/{id}")
    public AppUser findById(@PathVariable int id) {
        return appUserService.findOne(id);
    }
    
    @DeleteMapping("/delete-appUser/{id}")
    public void deleteById(@PathVariable int id) {
        appUserService.deleteById(id);
    }
}