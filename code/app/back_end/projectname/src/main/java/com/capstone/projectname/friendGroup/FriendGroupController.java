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
    
    @GetMapping("/find-friendGroup")
    public List<FriendGroup> findAll() {
        return friendGroupService.findAll();
    }
    
    @GetMapping("/find-friendGroup/{id}")
    public FriendGroup findById() {
        return friendGroupService.findOne(1);
    }

    @PostMapping("/create-friendGroup")
    public ResponseEntity<FriendGroup> create(@Valid @RequestBody FriendGroup friendGroup) {
        FriendGroup savedFriendGroup = friendGroupService.save(friendGroup);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedFriendGroup.getGroupId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete-friendGroup/{id}")
    public void deleteById() {
        friendGroupService.deleteById(1);
    }
}
