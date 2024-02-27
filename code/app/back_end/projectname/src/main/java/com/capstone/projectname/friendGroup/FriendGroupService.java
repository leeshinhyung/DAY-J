package com.capstone.projectname.friendGroup;

import com.capstone.projectname.appUser.AppUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class FriendGroupService {
    private static List<FriendGroup> friendGroups = new ArrayList<>();
    private static int friendGroupsCount = 0;

    static {
        friendGroups.add(new FriendGroup(++friendGroupsCount, "study", "study hard", false));
        friendGroups.add(new FriendGroup(++friendGroupsCount, "lsh", "goooood", false));
        friendGroups.add(new FriendGroup(++friendGroupsCount, "capstone", "stone...", false));
    }
    
    public FriendGroup createFriendGroup(FriendGroup group) {
        group.setGroupId(++friendGroupsCount);
        friendGroups.add(group);
        return group;
    }

    public List<FriendGroup> readAllFriendGroup() {
        return friendGroups;
    }
    
    public FriendGroup readFriendGroupById(int id) {
        Predicate<? super FriendGroup> predicate = friendGroup -> friendGroup.getGroupId() == id;
        return friendGroups.stream().filter(predicate).findFirst().orElse(null);
    }

    public void updateFriendGroup(FriendGroup friendGroup) {
        Predicate<? super FriendGroup> predicate = group -> group.getGroupId() == friendGroup.getGroupId();
        FriendGroup prevFriendGroup = friendGroups.stream().filter(predicate).findFirst().orElse(null);
        friendGroups.remove(prevFriendGroup);
        friendGroups.add(friendGroup);
    }

    public void deleteFriendGroupById(int id){
        Predicate<? super FriendGroup> predicate = friendGroup -> friendGroup.getGroupId() == id;
        friendGroups.removeIf(predicate);
    }
}
