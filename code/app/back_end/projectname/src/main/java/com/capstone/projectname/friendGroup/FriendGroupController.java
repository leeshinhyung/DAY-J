package com.capstone.projectname.friendGroup;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FriendGroupController {
    FriendGroupService friendGroupService;
    
    
    public FriendGroupController(FriendGroupService friendGroupService) {
        this.friendGroupService = friendGroupService;
    }
    
    @PostMapping("/friendGroup/create")
    public ResponseEntity<FriendGroup> createFriendGroup(@Valid @RequestBody FriendGroup friendGroup) {
        FriendGroup savedFriendGroup = friendGroupService.createFriendGroup(friendGroup);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedFriendGroup.getGroupId())
                .toUri();
        return ResponseEntity.created(location).build();
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
