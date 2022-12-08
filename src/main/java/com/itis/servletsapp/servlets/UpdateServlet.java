package com.itis.servletsapp.servlets;

import com.itis.servletsapp.model.Post;
import com.itis.servletsapp.services.PostService;
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

@WebServlet(name = "UpdateServlet", value = "/posts/update")
@MultipartConfig
public class UpdateServlet extends HttpServlet {

    private final PostService postService = new PostServiceImpl();

    private Long postID;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long postID = Long.parseLong(request.getParameter("postID"));
        this.postID = postID;
        Post post = postService.findPost(postID);

        request.setAttribute("post", post);
        request.getRequestDispatcher("/WEB-INF/view/update_post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part part = request.getPart("img");
        Post post = postService.findPost(postID);

        post.setTitle(request.getParameter("title"));
        post.setText(request.getParameter("text"));

        if (!part.getSubmittedFileName().equals("")){
            String imgName = UUID.randomUUID() + "_" + part.getSubmittedFileName();
            post.setImgName(imgName);
            post.setImg(part.getInputStream().readAllBytes());
        }
        postService.updatePost(post);
        response.sendRedirect("/school/posts");
    }
}
