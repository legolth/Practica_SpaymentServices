package com.reto.crud.reto2.controller;

import com.reto.crud.reto2.model.Post;
import com.reto.crud.reto2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }
}