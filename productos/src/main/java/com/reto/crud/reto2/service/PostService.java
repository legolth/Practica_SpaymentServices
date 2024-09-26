package com.reto.crud.reto2.service;
import com.reto.crud.reto2.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsByUserId(Long userId);
}