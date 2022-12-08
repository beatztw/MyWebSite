package com.itis.servletsapp.services.impl;

import com.itis.servletsapp.dao.CommentRepository;
import com.itis.servletsapp.dao.impl.CommentRepositoryImpl;
import com.itis.servletsapp.model.Comment;
import com.itis.servletsapp.services.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private static final CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
