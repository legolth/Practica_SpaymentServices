package com.reto.crud.reto2.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sps.codeinterview.reto2.model.Post;
import sps.codeinterview.reto2.service.PostService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private static final String API_GET = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        Post[] postsArray = restTemplate.getForObject(API_GET, Post[].class);

        if (postsArray != null) {
            List<Post> posts = Arrays.asList(postsArray);
            // Filtrar los posts por userId
            return posts.stream()
                    .filter(post -> post.getUserId().equals(userId))
                    .collect(Collectors.toList());
        }
        return List.of(); // Retorna una lista vacía si no se encuentran posts
    }
}