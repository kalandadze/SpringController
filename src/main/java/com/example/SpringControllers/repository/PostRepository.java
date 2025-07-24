package com.example.SpringControllers.repository;

import com.example.SpringControllers.model.Post;
import lombok.Getter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Getter
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllByUserEmail(String email);
//    private final List<Post> posts=new ArrayList<>();
//
//    public void addPost(Post post){
//        posts.add(post);
//    }
//    public boolean removePost(Post post){
//        return posts.remove(post);
//    }
}
