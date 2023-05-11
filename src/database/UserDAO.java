package database;

import enums.UserType;  
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.User;

/**

This class represents a Data Access Object (DAO) for the User entity. It provides methods for performing
CRUD (Create, Read, Update, Delete) operations on User objects in the database.
*/
public class UserDAO {
    private static Connection connection;

    /**
 * Default constructor for UserDAO.
 * 
 * @throws SQLException if an error occurs while connecting to the database
 */

    public UserDAO() throws SQLException {
    }

/**
 * Retrieves a list of all users in the database.
 * 
 * @return a list of all users in the database
 * @throws SQLException if an error occurs while executing the SQL query
 */
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
        Connect.closeConnection();
        return users;
    }

/**
 * Retrieves a user from the database by their username.
 * 
 * @param username the username of the user to retrieve
 * @return the User object representing the retrieved user, or null if the user was not found
 * @throws SQLException if an error occurs while executing the SQL query
 */
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
    

/**
 * Retrieves a user from the database by their ID.
 * 
 * @param ID the ID of the user to retrieve
 * @return the User object representing the retrieved user, or null if the user was not found
 * @throws SQLException if an error occurs while executing the SQL query
 */
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

/**
 * Checks if a user with the given username exists in the database.
 * 
 * @param username the username of the user to check for existence
 * @return true if the user exists in the database, false otherwise
 * @throws SQLException if an error occurs while executing the SQL query
 */
    public static boolean userExists(String username) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Connect.closeConnection();
                return true;
            }
        }finally{ 
            Connect.closeConnection();
        }
        return false;
    }

/**
 * Adds a user to the database.
 * 
 * @param user the User object representing the user to add
 * @throws SQLException if an error occurs while executing the SQL query
 */
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

/**
 * Updates an existing user in the database.
 * 
 * @param user the User object representing the user to update
 * @throws SQLException if an error occurs while executing the SQL query
 */
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

/**
 * Deletes a user from the database.
 * 
 * @param user the User object representing the user to delete
 * @throws SQLException if an error occurs while executing the SQL query
 */
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

