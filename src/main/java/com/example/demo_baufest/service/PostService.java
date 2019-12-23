package com.example.demo_baufest.service;

import com.example.demo_baufest.model.Post;
import com.example.demo_baufest.model.PostDTO;
import com.example.demo_baufest.model.User;
import com.example.demo_baufest.repository.PostRepository;
import com.example.demo_baufest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Post createPost(PostDTO postDTO){
        try{
            User user = userRepository.findById(postDTO.getUserId()).orElse(null);
            if (user != null){
                Post newPost = new Post(postDTO.getTitle(),user,postDTO.getText());
                return postRepository.save(newPost);
            } else {
                throw new UnsupportedOperationException("User not found");
            }
        }
        catch (UnsupportedOperationException e){
            e.printStackTrace();
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new UnsupportedOperationException("JPA failed to save resource");
        }
    }
}
