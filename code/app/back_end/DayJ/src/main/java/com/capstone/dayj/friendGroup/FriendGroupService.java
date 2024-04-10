package com.capstone.dayj.friendGroup;

import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import com.capstone.dayj.plan.Plan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<FriendGroup> friendGroups = friendGroupRepository.findAll();
        
        if (friendGroups.isEmpty())
            throw new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND);
        
        return friendGroupRepository.findAll();
    }
    
    public FriendGroup readFriendGroupById(int id) {
        return friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));
    }
    
    public void updateFriendGroup(int id, FriendGroup friendGroup) {
        FriendGroup existingFriendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));
        
        existingFriendGroup.setId(friendGroup.getId());
        friendGroupRepository.save(existingFriendGroup);
    }
    
    public void deleteFriendGroupById(int id) {
        friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));
        
        friendGroupRepository.deleteById(id);
    }
}
