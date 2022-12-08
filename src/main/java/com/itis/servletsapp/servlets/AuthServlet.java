package com.itis.servletsapp.servlets;

import com.itis.servletsapp.model.User;
import com.itis.servletsapp.services.UserService;
import com.itis.servletsapp.services.impl.UserServiceImpl;
import com.itis.servletsapp.utils.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logon = request.getParameter("login");
        String password = MD5.hashPassword(request.getParameter("password"));

        UserService userService = new UserServiceImpl();
        List<User> users = userService.getUsers();

        for (User user : users) {
            if(user.getLogin().equals(logon) && user.getPassword().equals(password)){
                request.getSession().setAttribute("authUser", user);
                response.sendRedirect("/school/home");
                return;
            }
        }
        response.sendRedirect("/school/auth");
    }
}
