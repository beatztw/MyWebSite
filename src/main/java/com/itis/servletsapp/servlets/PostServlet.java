package com.itis.servletsapp.servlets;

import com.itis.servletsapp.model.Comment;
import com.itis.servletsapp.model.Post;
import com.itis.servletsapp.model.User;
import com.itis.servletsapp.services.CommentService;
import com.itis.servletsapp.services.PostService;
import com.itis.servletsapp.services.UserService;
import com.itis.servletsapp.services.impl.CommentServiceImpl;
import com.itis.servletsapp.services.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PostServlet", value = "/posts/*")
public class PostServlet extends HttpServlet {

    private final PostService postService = new PostServiceImpl();

    private final CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long postID = Long.valueOf(request.getPathInfo().substring(1));
            List<Comment> comments = commentService.getComments().stream()
                    .filter(comment -> comment.getPostID().equals(postID))
                    .collect(Collectors.toList());
            Post post = postService.findPost(postID);

            request.setAttribute("post", post);
            request.setAttribute("comments", comments);
            request.setAttribute("isAdmin", UserService.isAdmin());
            request.setAttribute("isAuth", UserService.isAuth());
            request.getRequestDispatcher("/WEB-INF/view/post.jsp").forward(request, response);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long postID = Long.valueOf(request.getPathInfo().substring(1));

        Comment comment = Comment.builder()
                .text(request.getParameter("text"))
                .userID(UserService.getAuthUser().getId())
                .postID(postID)
                .build();
        commentService.saveComment(comment);

        response.sendRedirect("/school/posts/" + postID);
    }
}
