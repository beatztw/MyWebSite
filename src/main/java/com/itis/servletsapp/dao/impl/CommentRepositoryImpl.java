package com.itis.servletsapp.dao.impl;

import com.itis.servletsapp.config.ConnectionProvider;
import com.itis.servletsapp.dao.CommentRepository;
import com.itis.servletsapp.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CommentRepositoryImpl implements CommentRepository {
    // language=SQL
    private static final String SQL_SAVE_COMMENT = "INSERT INTO comments_table (text, user_id, post_id) " +
            "VALUES (?, ?, ?)";
    // language=SQL
    private static final String SQL_FIND_ALL_COMMENT = "SELECT * FROM comments_table";
    // language=SQL
    private static final String SQL_DELETE_COMMENT_BY_ID = "DELETE FROM comments_table WHERE id = ?";
    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Comment> findAll() {
        try(Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_COMMENT);
            ResultSet resultSet = statement.executeQuery();
            List<Comment> comments = new LinkedList<>();

            while (resultSet.next()){
                Comment comment = Comment.builder()
                        .id(resultSet.getLong("id"))
                        .text(resultSet.getString("text"))
                        .userID(resultSet.getLong("user_id"))
                        .postID(resultSet.getLong("post_id"))
                        .build();
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void save(Comment comment) {
        try(Connection connection = ConnectionProvider.getConnection()){
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_COMMENT);

            statement.setString(1, comment.getText());
            statement.setLong(2, comment.getUserID());
            statement.setLong(3, comment.getPostID());

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionProvider.getConnection()){
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COMMENT_BY_ID);

            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Comment comment) {
        //TODO:
    }
}
