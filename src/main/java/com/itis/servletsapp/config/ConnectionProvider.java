package com.itis.servletsapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection getConnection() {
        try {
            Class.forName(ConnectionProperties.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find driver class ");
        }

        try {
            return DriverManager.getConnection(ConnectionProperties.URL,
                    ConnectionProperties.USERNAME,
                    ConnectionProperties.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Unable to receive connection ");
            throw new RuntimeException(e);
        }
    }
}
