package com.itis.servletsapp.services;

import com.itis.servletsapp.model.Post;

import java.util.List;

public interface PostService {
    void savePost(Post post);

    void deletePost(Long id);

    void updatePost(Post post);

    Post findPost(Long id);

    List<Post> getPosts();

}
