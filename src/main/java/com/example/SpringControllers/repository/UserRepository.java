package com.example.SpringControllers.repository;

import com.example.SpringControllers.model.Post;
import com.example.SpringControllers.model.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class UserRepository {
    private final List<User> users=new ArrayList<>();

    public void addUsers(User user){
        users.add(user);
    }
    public boolean removeUser(User user){
        return users.remove(user);
    }
}
