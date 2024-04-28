package com.capstone.dayj.setting;


import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.appUser.AppUserDto;
import com.capstone.dayj.appUser.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {
    private SettingService settingService;
    private AppUserService appUserService;
    
    public SettingController(SettingService settingService, AppUserService appUserService) {
        this.settingService = settingService;
        this.appUserService = appUserService;
    }
    
    @GetMapping("/appUser/read/{id}/setting")
    public Setting readSettingForUser(@PathVariable int id) {
        AppUserDto.Response appUser = appUserService.readAppUserById(id);
        return appUser.getSetting();
    }
}
