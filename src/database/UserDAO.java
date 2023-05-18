package database;

import enums.UserType;  
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            connection = Connect.connectToDatabase();
            String sql = "INSERT INTO users (username, password, name, user_type) VALUES (?, ?, ?, ?)";
            String passwordToEncrypt = user.getPassword();
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-256");
            md.update(passwordToEncrypt.getBytes());
            byte[] bytes = md.digest();
            String encryptedPassword = Base64.getEncoder().encodeToString(bytes);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, encryptedPassword);
                statement.setString(3, user.getName());
                statement.setString(4, user.getType().toString());
                statement.executeUpdate();
            }
            Connect.closeConnection();
        }   catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**
 * Updates an existing user in the database.
 * 
 * @param user the User object representing the user to update
 * @throws SQLException if an error occurs while executing the SQL query
 */
    public static void updateUser(User user) throws SQLException {
        try {
            connection = Connect.connectToDatabase();
            String sql = "UPDATE users SET username = ?, password = ?, name = ?, user_type = ? WHERE user_id = ?";
            String passwordToEncrypt = user.getPassword();
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-256");
            md.update(passwordToEncrypt.getBytes());
            byte[] bytes = md.digest();
            String encryptedPassword = Base64.getEncoder().encodeToString(bytes);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, encryptedPassword);
                statement.setString(3, user.getName());
                statement.setString(4, user.getType().toString());
                statement.setInt(5, user.getUserID());
                statement.executeUpdate();
            }
            Connect.closeConnection();
        }   catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    /**
     * Counts the number of admin users in the "users" table.
     *
     * @return The number of admin users.
     * @throws SQLException If an error occurs while accessing the database.
     */
    public static int countAdminUsers() throws SQLException {
        int count = 0;
        try (Connection conn = Connect.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE user_type = 'ADMIN'"); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException("Error counting admin users: " + e.getMessage());
        } finally {
            Connect.closeConnection();
        }
        return count;
    }


}

