package com.capstone.dayj.friendGroup;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendGroupController {
    FriendGroupService friendGroupService;
    
    
    public FriendGroupController(FriendGroupService friendGroupService) {
        this.friendGroupService = friendGroupService;
    }
    
    @PostMapping("/friendGroup/create")
    public void createFriendGroup(@Valid @RequestBody FriendGroup friendGroup) {
        friendGroupService.createFriendGroup(friendGroup);
    }
    
    @GetMapping("/friendGroup/read")
    public List<FriendGroup> readAllFriendGroup() {
        return friendGroupService.readAllFriendGroup();
    }
    
    @GetMapping("/friendGroup/read/{id}")
    public FriendGroup readFriendGroupById(@PathVariable int id) {
        return friendGroupService.readFriendGroupById(id);
    }
    
    @GetMapping("/friendGroup/update/{id}")
    public FriendGroup updateFriendGroupView(@PathVariable int id) {
        return friendGroupService.readFriendGroupById(id);
    }

    @PatchMapping("/friendGroup/update/{id}")
    public void patchFriendGroup(@Valid @RequestBody FriendGroup friendGroup) {
        friendGroupService.updateFriendGroup(friendGroup);
    }

    @DeleteMapping("/friendGroup/delete/{id}")
    public void deleteFriendGroupById(@PathVariable int id) {
       friendGroupService.deleteFriendGroupById(id);
    }
}
