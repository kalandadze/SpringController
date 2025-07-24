package com.example.SpringControllers.repository;

import com.example.SpringControllers.model.Post;
import com.example.SpringControllers.model.User;
import lombok.Getter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Getter
@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByEmail(String email);

    Optional<User> findAllByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
//    private final List<User> users=new ArrayList<>();
//
//    public void addUsers(User user){
//        users.add(user);
//    }
//    public boolean removeUser(User user){
//        return users.remove(user);
//    }
}
