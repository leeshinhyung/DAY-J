package com.capstone.dayj.friendGroup;

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
        return friendGroupRepository.findAll();
    }
    
    public Optional<FriendGroup> readFriendGroupById(int id) {
        return Optional.ofNullable(friendGroupRepository.findById(id)
                .orElseThrow(() -> new FriendGroupNotFoundException("해당 id를 가진 그룹이 없습니다.")));
    }
    
    public void updateFriendGroup(int id, FriendGroup friendGroup) {
        FriendGroup existingFriendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new FriendGroupNotFoundException("해당 id를 가진 그룹이 없습니다."));
        
        existingFriendGroup.setId(friendGroup.getId());
        friendGroupRepository.save(existingFriendGroup);
    }
    
    public void deleteFriendGroupById(int id) {
        friendGroupRepository.deleteById(id);
    }
}
