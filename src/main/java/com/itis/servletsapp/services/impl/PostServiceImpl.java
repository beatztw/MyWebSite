package com.itis.servletsapp.services.impl;

import com.itis.servletsapp.dao.PostsRepository;
import com.itis.servletsapp.dao.impl.PostsRepositoryImpl;
import com.itis.servletsapp.model.Post;
import com.itis.servletsapp.services.PostService;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {
    private static final PostsRepository postsRepository = new PostsRepositoryImpl();

    @Override
    public void savePost(Post post) {
        postsRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postsRepository.delete(id);
    }

    @Override
    public void updatePost(Post post) {
        postsRepository.update(post);
    }

    @Override
    public Post findPost(Long id) {
        Optional<Post> post = postsRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new IllegalArgumentException("No such post");
        }
    }

    @Override
    public List<Post> getPosts() {
        return postsRepository.findAll();
    }
}
