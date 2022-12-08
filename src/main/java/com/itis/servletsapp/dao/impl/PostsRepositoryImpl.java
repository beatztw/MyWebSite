package com.itis.servletsapp.dao.impl;

import com.itis.servletsapp.config.ConnectionProvider;
import com.itis.servletsapp.dao.PostsRepository;
import com.itis.servletsapp.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PostsRepositoryImpl implements PostsRepository {
    // language=SQL
    public static final String SQL_FIND_ALL_POSTS = "SELECT * FROM posts_table";

    // language=SQL
    public static final String SQL_FIND_POST_BY_ID = "SELECT * FROM posts_table WHERE id = ?";

    // language=SQL
    public static final String SQL_SAVE_POST = "INSERT INTO posts_table (title, text, imgname, img, user_id) " +
            "VALUES (?, ?, ?, ?, ?)";

    // language=SQL
    public static final String SQL_DELETE_POST_BY_ID = "DELETE FROM posts_table WHERE id = ?";

    // language=SQL
    public static final String SQL_UPDATE_POST = "UPDATE posts_table SET (title, text, img, imgname) = (?, ?, ?, ?) " +
            "WHERE id = ?";



    @Override
    public Optional<Post> findById(Long id) {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_POST_BY_ID);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return Optional.of(
                        Post.builder()
                                .id(resultSet.getLong("id"))
                                .title(resultSet.getString("title"))
                                .text(resultSet.getString("text"))
                                .img(resultSet.getBytes("img"))
                                .imgName(resultSet.getString("imgname"))
                                .userID(resultSet.getLong("user_id"))
                                .build()
                );
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Post> findAll() {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_POSTS);
            ResultSet resultSet = statement.executeQuery();
            List<Post> posts = new LinkedList<>();

            while (resultSet.next()){
                Post post = Post.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .text(resultSet.getString("text"))
                        .img(resultSet.getBytes("img"))
                        .imgName(resultSet.getString("imgname"))
                        .userID(resultSet.getLong("user_id"))
                        .build();

                posts.add(post);
            }
            return posts;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void save(Post post) {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_POST);

            statement.setString(1, post.getTitle());
            statement.setString(2, post.getText());
            statement.setString(3, post.getImgName());
            statement.setBytes(4, post.getImg());
            statement.setLong(5, post.getUserID());

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_POST_BY_ID);

            statement.setLong(1,id);

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Post post) {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_POST);

            statement.setString(1, post.getTitle());
            statement.setString(2, post.getText());
            statement.setBytes(3, post.getImg());
            statement.setString(4, post.getImgName());
            statement.setLong(5, post.getId());

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
