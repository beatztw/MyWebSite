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

@WebServlet(name = "RegistrationServlet", value = "/reg")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/reg.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = MD5.hashPassword(request.getParameter("password"));


        UserService userService = new UserServiceImpl();
        List<User> users = userService.getUsers();

        boolean exists = users.stream()
                .anyMatch(user -> user.getLogin().equals(login));

        if(!exists){
            User user = User.builder()
                    .login(login)
                    .password(password)
                    .build();
            userService.save(user);

            response.sendRedirect("/school/home");

        } else response.sendRedirect("/school/reg");
    }
}
