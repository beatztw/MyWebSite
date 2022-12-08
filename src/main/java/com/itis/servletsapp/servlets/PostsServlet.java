package com.itis.servletsapp.servlets;

import com.itis.servletsapp.model.Post;
import com.itis.servletsapp.services.PostService;
import com.itis.servletsapp.services.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostsServlet", value = "/posts")
public class PostsServlet extends HttpServlet {

    private final PostService postService = new PostServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Post> posts = postService.getPosts();
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/WEB-INF/view/posts.jsp").forward(request, response);
    }
}
