package com.capstone.dayj.appUser;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    
    public Optional<AppUser> readAppUserById(int id) {
        return Optional.ofNullable(appUserRepository.findById(id)
                .orElseThrow(() -> new AppUserNotFoundException("해당 id를 가진 사용자가 없습니다.")));
    }
    
    public void updateAppUser(int id, AppUser appUser) {
        AppUser existingAppUser = appUserRepository.findById(id)
                .orElseThrow(() -> new AppUserNotFoundException("해당 id를 가진 사용자가 없습니다."));
        
        existingAppUser.setId(appUser.getId());
        existingAppUser.setPassword(appUser.getPassword());
        appUserRepository.save(existingAppUser);
    }
    
    public void deleteAppUserById(int id) {
        appUserRepository.deleteById(id);
    }
}
