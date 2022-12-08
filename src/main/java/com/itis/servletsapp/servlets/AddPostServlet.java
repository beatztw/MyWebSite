package com.itis.servletsapp.servlets;

import com.itis.servletsapp.model.Post;
import com.itis.servletsapp.services.PostService;
import com.itis.servletsapp.services.UserService;
import com.itis.servletsapp.services.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "AddPostServlet", value = "/posts/add")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

    private final PostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part part = request.getPart("img");
        String fileName = UUID.randomUUID() + "_" + part.getSubmittedFileName();

        Post post = Post.builder()
                .title(request.getParameter("title"))
                .text(request.getParameter("text"))
                .img(part.getInputStream().readAllBytes())
                .imgName(fileName)
                .userID(UserService.getAuthUser().getId())
                .build();

        postService.savePost(post);
        response.sendRedirect("/school/posts");
    }
}
