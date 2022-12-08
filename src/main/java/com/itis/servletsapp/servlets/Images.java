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

@WebServlet(urlPatterns = "/images/*")
public class Images extends HttpServlet {

    private final PostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String imgName = request.getPathInfo().substring(1);
        List<Post> posts = postService.getPosts();

        for (Post post : posts) {
            if (post.getImgName().equals(imgName)){
                byte[] img = post.getImg();
                response.setContentType(getServletContext().getMimeType(imgName));
                response.setContentLength(img.length);
                response.getOutputStream().write(img);
                return;
            }
        }
    }
}
