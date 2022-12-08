package com.itis.servletsapp.services;

import com.itis.servletsapp.model.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment);

    void deleteComment(Long id);

    List<Comment> getComments();
}
