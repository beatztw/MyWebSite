package com.itis.servletsapp.utils;

import com.itis.servletsapp.model.User;
import com.itis.servletsapp.services.UserService;
import com.itis.servletsapp.services.impl.UserServiceImpl;

public class PostUtils {

    public static boolean isPostBelongsToUser(Long userID){
        return UserService.isAuth() && UserService.getAuthUser().getId().equals(userID);
    }

    public static String getUsernameWithID(Long userID){
        UserService userService = new UserServiceImpl();
        for (User user: userService.getUsers()) {
            if (user.getId().equals(userID)){
                return user.getLogin();
            }
        }
        return "";
    }
}
