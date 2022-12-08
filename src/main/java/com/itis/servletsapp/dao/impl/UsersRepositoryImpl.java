package com.itis.servletsapp.dao.impl;

import com.itis.servletsapp.config.ConnectionProvider;
import com.itis.servletsapp.dao.UsersRepository;
import com.itis.servletsapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {
    // language=SQL
    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users_table";
   // language=SQL
    private static final String SQL_SAVE_USER = "INSERT INTO users_table (login, password) " +
           "VALUES (?, ?)";
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new LinkedList<>();

            while (resultSet.next()){
                User user = User.builder()
                        .id(resultSet.getLong("id"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .role(resultSet.getString("role"))
                        .build();

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void save(User user) {
        try(Connection connection = ConnectionProvider.getConnection()){
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_USER);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(Long id) {
        //TODO:
    }

    @Override
    public void update(User item) {
        //TODO:
    }
}
