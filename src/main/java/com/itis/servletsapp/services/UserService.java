package com.itis.servletsapp.services;

import com.itis.servletsapp.listeners.InitListener;
import com.itis.servletsapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    List<User> getUsers();

    static boolean isAdmin() {
        return InitListener.getAuthUser().isPresent() && InitListener.getAuthUser().get().getRole().equals("admin");
    }

    static boolean isAuth() {
        return InitListener.getAuthUser().isPresent();
    }

    static User getAuthUser() {
        Optional<User> user = InitListener.getAuthUser();
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalArgumentException("Auth error");
        }
    }


}
