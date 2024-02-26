package com.capstone.projectname.friendGroup;

import com.capstone.projectname.appUser.AppUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.projectname.post.Post;

import java.util.List;

@RestController
public class FriendGroupController {
    FriendGroupRepository friendGroupRepository;
    
    
    public FriendGroupController(FriendGroupRepository friendGroupRepository) {
        this.friendGroupRepository = friendGroupRepository;
    }
    
    @GetMapping("/find-friendGroup")
    public List<FriendGroup> findAll() {
        return friendGroupRepository.findAll();
    }
    
    @GetMapping("/find-friendGroup-id")
    public FriendGroup findById() {
        return friendGroupRepository.findById(1).get();
    }
    
    @GetMapping("/delete-friendGroup-id")
    public void deleteById() {
    	friendGroupRepository.deleteById(1);
    }

    @PostMapping("/update-friendGroup")
    public void update(@Valid @RequestBody FriendGroup friendGroup) {
        FriendGroup savedFriendGroup = friendGroupRepository.save(friendGroup);
    }
}
