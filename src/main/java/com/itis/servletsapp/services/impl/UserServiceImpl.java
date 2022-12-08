package com.itis.servletsapp.services.impl;

import com.itis.servletsapp.dao.UsersRepository;
import com.itis.servletsapp.dao.impl.UsersRepositoryImpl;
import com.itis.servletsapp.model.User;
import com.itis.servletsapp.services.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository = new UsersRepositoryImpl();

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }



}
