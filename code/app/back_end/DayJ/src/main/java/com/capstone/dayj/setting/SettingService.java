package com.capstone.dayj.setting;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {
    private SettingRepository settingRepository;

    public SettingService(SettingRepository settingRepository){
        this.settingRepository = settingRepository;
    }

    public void createSetting(Setting setting){
        settingRepository.save(setting);
    }

    public List<Setting> readAllSetting(){
        return settingRepository.findAll();
    }

    public Setting readSettingById(int id){
        return settingRepository.findById(id).get();
    }

    public void updateSetting(Setting setting){
        settingRepository.save(setting);
    }

    public void deleteSettingById(int id){
        settingRepository.deleteById(id);
    }
}
