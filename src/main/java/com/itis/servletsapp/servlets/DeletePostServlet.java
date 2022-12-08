package com.itis.servletsapp.servlets;

import com.itis.servletsapp.services.CommentService;
import com.itis.servletsapp.services.PostService;
import com.itis.servletsapp.services.impl.CommentServiceImpl;
import com.itis.servletsapp.services.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePostServlet", value = "/posts/delete")
public class DeletePostServlet extends HttpServlet {

    private final CommentService commentService = new CommentServiceImpl();

    private final PostService postService = new PostServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long postID = Long.parseLong(request.getParameter("postID"));

        commentService.getComments()
                .forEach(comment -> {
                    if (comment.getPostID().equals(postID)){
                        commentService.deleteComment(comment.getId());
                    }
                });
        postService.deletePost(postID);

        response.sendRedirect("/school/posts");
    }
}
