package com.capstone.projectname.friendGroup;

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

    public List<FriendGroup> findAll() {
        return friendGroups;
    }

    public FriendGroup save(FriendGroup group){
        group.setGroupId(++friendGroupsCount);
        friendGroups.add(group);
        return group;
    }

    public FriendGroup findOne(int id) {
        Predicate<? super FriendGroup> predicate = friendGroup -> friendGroup.getGroupId() == id;
        return friendGroups.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id){
        Predicate<? super FriendGroup> predicate = friendGroup -> friendGroup.getGroupId() == id;
        friendGroups.removeIf(predicate);
    }
}
