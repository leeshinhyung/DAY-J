package com.capstone.dayj.appUser;


import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
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
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND)));
    }
    
    public void updateAppUser(int id, AppUser appUser) {
        AppUser existingAppUser = appUserRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        
        existingAppUser.setId(appUser.getId());
        existingAppUser.setPassword(appUser.getPassword());
        appUserRepository.save(existingAppUser);
    }
    
    public void deleteAppUserById(int id) {
        appUserRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));

        appUserRepository.deleteById(id);
    }
}
