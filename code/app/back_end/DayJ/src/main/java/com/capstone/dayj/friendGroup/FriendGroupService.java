package com.capstone.dayj.friendGroup;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendGroupService {
    private FriendGroupRepository friendGroupRepository;
    
    public FriendGroupService(FriendGroupRepository friendGroupRepository) {
        this.friendGroupRepository = friendGroupRepository;
    }
    
    public void createFriendGroup(FriendGroup group) {
        friendGroupRepository.save(group);
    }
    
    public List<FriendGroup> readAllFriendGroup() {
        return friendGroupRepository.findAll();
    }
    
    public FriendGroup readFriendGroupById(int id) {
        return friendGroupRepository.findById(id).get();
    }
    
    public void updateFriendGroup(FriendGroup friendGroup) {
        friendGroupRepository.save(friendGroup);
    }
    
    public void deleteFriendGroupById(int id) {
        friendGroupRepository.deleteById(id);
    }
}
