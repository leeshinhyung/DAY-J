package com.capstone.projectname.appUser;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private AppUserRepository appUserRepository;
    
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    
    public AppUser createAppUser(AppUser user) {
        return appUserRepository.save(user);
    }
    
    public List<AppUser> readAllAppUser() {
        return appUserRepository.findAll();
    }
    
    public AppUser readAppUserById(int id) {
        return appUserRepository.findById(id).get();
    }
    
    public void updateAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }
    
    public void deleteAppUserById(int id) {
        appUserRepository.deleteById(id);
    }
}
