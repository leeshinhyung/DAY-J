package com.capstone.dayj.setting;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {
    private SettingService settingService;

    public SettingController(SettingService settingService){
        this.settingService = settingService;
    }
}
