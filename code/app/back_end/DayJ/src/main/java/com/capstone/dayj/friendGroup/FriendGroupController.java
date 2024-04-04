package com.capstone.dayj.friendGroup;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend-group")
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
        return friendGroupService.readFriendGroupById(id).get();
    }
    
    @PatchMapping("/{id}")
    public void patchFriendGroup(@PathVariable int id, @Valid @RequestBody FriendGroup friendGroup) {
        friendGroupService.updateFriendGroup(id, friendGroup);
    }
    
    @DeleteMapping("/{id}")
    public void deleteFriendGroupById(@PathVariable int id) {
        friendGroupService.deleteFriendGroupById(id);
    }
}
