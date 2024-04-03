package com.capstone.dayj.friendGroup;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friendGroup")
public class FriendGroupController {
    FriendGroupService friendGroupService;
    
    
    public FriendGroupController(FriendGroupService friendGroupService) {
        this.friendGroupService = friendGroupService;
    }
    
    @PostMapping
    public void createFriendGroup(@Valid @RequestBody FriendGroup friendGroup) {
        friendGroupService.createFriendGroup(friendGroup);
    }
    
    @GetMapping
    public List<FriendGroup> readAllFriendGroup() {
        return friendGroupService.readAllFriendGroup();
    }
    
    @GetMapping("/{id}")
    public FriendGroup readFriendGroupById(@PathVariable int id) {
        return friendGroupService.readFriendGroupById(id);
    }
    
    @PatchMapping("/{id}")
    public void patchFriendGroup(@Valid @RequestBody FriendGroup friendGroup) {
        friendGroupService.updateFriendGroup(friendGroup);
    }
    
    @DeleteMapping("/{id}")
    public void deleteFriendGroupById(@PathVariable int id) {
        friendGroupService.deleteFriendGroupById(id);
    }
}
