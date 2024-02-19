package com.capstone.projectname.fgroup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FGroupController {
    FGroupRepository fgroupRepository;
    
    
    public FGroupController(FGroupRepository fgroupRepository) {
        this.fgroupRepository = fgroupRepository;
    }
    
    @GetMapping("/test-fgroup")
    public List<FGroup> returnTest() {
        List<FGroup> fgroups = fgroupRepository.findAll();
        return fgroups;
    }
}
