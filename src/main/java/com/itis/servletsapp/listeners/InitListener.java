package com.itis.servletsapp.listeners;

import com.itis.servletsapp.config.ConnectionProvider;
import com.itis.servletsapp.dao.CommentRepository;
import com.itis.servletsapp.dao.PostsRepository;
import com.itis.servletsapp.dao.UsersRepository;
import com.itis.servletsapp.dao.impl.CommentRepositoryImpl;
import com.itis.servletsapp.dao.impl.PostsRepositoryImpl;
import com.itis.servletsapp.dao.impl.UsersRepositoryImpl;
import com.itis.servletsapp.model.User;
import com.itis.servletsapp.services.CommentService;
import com.itis.servletsapp.services.PostService;
import com.itis.servletsapp.services.UserService;
import com.itis.servletsapp.services.impl.CommentServiceImpl;
import com.itis.servletsapp.services.impl.PostServiceImpl;
import com.itis.servletsapp.services.impl.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

@WebListener
public class InitListener implements ServletContextListener, HttpSessionListener {
    private static HttpSession session;

    public static Optional<User> getAuthUser() {
        User user = (User) session.getAttribute("authUser");
        if (user != null) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
        CommentService commentService = new CommentServiceImpl();

        UsersRepository usersRepository = new UsersRepositoryImpl();
        PostsRepository postsRepository = new PostsRepositoryImpl();
        CommentRepository commentRepository = new CommentRepositoryImpl();
    }

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        session = sessionEvent.getSession();

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        /* Session is destroyed. */
    }
}
