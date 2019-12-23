package com.example.demo_baufest.resource;

import com.example.demo_baufest.model.Post;
import com.example.demo_baufest.model.PostDTO;
import com.example.demo_baufest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @PostMapping
    @ResponseBody
    public ResponseEntity createPost(@RequestBody @Valid PostDTO postDTO){
        postService.createPost(postDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
