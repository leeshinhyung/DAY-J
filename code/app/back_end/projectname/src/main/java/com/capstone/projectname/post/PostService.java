package com.capstone.projectname.post;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class PostService {
    private static List<Post> posts = new ArrayList<>();
    private static int postsCount = 0;
    
    static {
        posts.add(new Post(++postsCount, 0, 0, "234241", "jaeho 수염",
                "면도", "", LocalDate.now(), LocalDate.now(),
                false, false, "good"));
        posts.add(new Post(++postsCount, 0, 0, "3124151", "jaeho 수염",
                "면도", "", LocalDate.now(), LocalDate.now(),
                false, false, "good"));
        posts.add(new Post(++postsCount, 0, 0, "12312", "jaeho 수염",
                "면도", "", LocalDate.now(), LocalDate.now(),
                false, false, "good"));
    }
    
    public Post save(Post user) {
        user.setId(++postsCount);
        posts.add(user);
        return user;
    }
    
    public List<Post> findAll() {
        return posts;
    }
    
    public Post findOne(int id) {
        Predicate<? super Post> predicate = post -> post.getId() == id;
        return posts.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public void deleteById(int id) {
        Predicate<? super Post> predicate = post -> post.getId() == id;
        posts.removeIf(predicate);
    }
}
