/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author Predator
 */

import enums.UserType;  
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import user.User;

public class UserDAO {
    private static Connection connection;

    public UserDAO() throws SQLException {
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        connection = Connect.connectToDatabase();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("user_id"),
                        UserType.valueOf(resultSet.getString("user_type")),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name")
                );
                users.add(user);
            }
        }
        //Connect.closeConnection();
        Connect.closeConnection();
        return users;
    }

    public static User getUserByUsername(String username) throws SQLException {
        User user = null;
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("user_id"),
                        UserType.valueOf(resultSet.getString("user_type")),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name")
                        
                );
            }
        }
        Connect.closeConnection();
        return user;
    }
    
    public static User getUserByID(int ID) throws SQLException {
        User user = null;
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("user_id"),
                        UserType.valueOf(resultSet.getString("user_type")),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name")
                        
                );
            }
        }
        Connect.closeConnection();
        return user;
    }

    public static void addUser(User user) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "INSERT INTO users (username, password, name, user_type) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getType().toString());
            statement.executeUpdate();
        }
      Connect.closeConnection();
    }

    public static void updateUser(User user) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "UPDATE users SET username = ?, password = ?, name = ?, user_type = ? WHERE user_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getType().toString());
            statement.setInt(5, user.getUserID());
            statement.executeUpdate();
        }
       Connect.closeConnection();
    }

    public static void deleteUser(User user) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserID());

            statement.executeUpdate();
        }
        Connect.closeConnection();
    }
}

