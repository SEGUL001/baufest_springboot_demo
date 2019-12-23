package com.example.demo_baufest.service;

import com.example.demo_baufest.model.User;
import com.example.demo_baufest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        try{
            if(validateUser(user)){
                return  userRepository.save(user);
            } else {
                throw new IllegalArgumentException("invalid User");
            }
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Internal Error");
        }
    }

    private boolean validateUser(User user){
        User findUser = userRepository.findByUserName(user.getUserName());

        return findUser == null;

    }

}
