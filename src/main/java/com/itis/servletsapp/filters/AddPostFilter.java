package com.itis.servletsapp.filters;

import com.itis.servletsapp.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/posts/add")
public class AddPostFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        if (!UserService.isAuth()) {
            response.sendRedirect("/school/auth");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
