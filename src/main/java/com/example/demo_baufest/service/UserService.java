package com.example.demo_baufest.service;

import com.example.demo_baufest.model.User;
import com.example.demo_baufest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        try{
            if(validateUser(user)){
                return  userRepository.save(user);
            } else {
                throw new IllegalArgumentException("Username already exist.");
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

    public ResponseEntity updateUser(User user){
        try{
            User oldUser = userRepository.findById(user.getId()).orElse(null);
            if (oldUser != null) {
                oldUser.setEmail(user.getEmail());
                oldUser.setUserName(user.getUserName());
                userRepository.save(oldUser);
                return new ResponseEntity(HttpStatus.OK);
            }
            else {
                throw  new IllegalArgumentException("user Not Found");
            }
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new UnsupportedOperationException("Error interno");
        }
    }

    public ResponseEntity deleteUser(User user){
        try{
            User oldUser = userRepository.findById(user.getId()).orElse(null);
            if (oldUser != null) {
                oldUser.getComments().clear();
                oldUser.getPosts().clear();
                userRepository.save(oldUser);
                userRepository.delete(oldUser);
                return new ResponseEntity(HttpStatus.OK);
            }
            else {
                throw  new IllegalArgumentException("user Not Found");
            }
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new UnsupportedOperationException("Error interno");
        }
    }

    private boolean validateUser(User user){
        User findUser = userRepository.findByUserName(user.getUserName());

        return findUser == null;

    }

}
