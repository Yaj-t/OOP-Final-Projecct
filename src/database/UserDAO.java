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
import room.Room;
import user.User;

public class UserDAO {
    private static Connection connection = Connect.connection;;

    public static Room getRoomById(int userID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public UserDAO() throws SQLException {
        // Initialize database connection
        if(Connect.connection == null){
            Connect.connectToDatabase();
        }
        connection = Connect.connection;
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

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

        return users;
    }

    public static User getUserByUsername(String username) throws SQLException {
        User user = null;

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

        return user;
    }
    
    public static User getUserByID(int ID) throws SQLException {
        User user = null;

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

        return user;
    }

    public static void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, name, user_type) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getType().toString());
            statement.executeUpdate();
        }
    }

    public static void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET username = ?, password = ?, name = ?, user_type = ? WHERE user_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getType().toString());
            statement.setInt(5, user.getUserID());
            statement.executeUpdate();
        }
    }

    public static void deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserID());

            statement.executeUpdate();
        }
    }
}

