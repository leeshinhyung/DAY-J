package com.capstone.projectname.friendGroup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendGroupController {
    FriendGroupRepository fgroupRepository;
    
    
    public FriendGroupController(FriendGroupRepository fgroupRepository) {
        this.fgroupRepository = fgroupRepository;
    }
    
    @GetMapping("/test-fgroup")
    public List<FriendGroup> returnTest() {
        List<FriendGroup> fgroups = fgroupRepository.findAll();
        return fgroups;
    }
}
