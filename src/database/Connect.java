/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Predator
 */
public class Connect {
    static Connection connection = null;

    public Connect() throws SQLException {
        // Initialize database connection
        connectToDatabase();
    }
   

    public static Connection connectToDatabase() throws SQLException {
        // Initialize database connection
        if(connection!=null){
            System.out.println("Already connected to database");
            return connection;
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomease", "root", "");
        if(connection == null){
            System.out.println("Connection Failed");
        }else{
            System.out.println("Connection Successful");
        }
        return connection;  
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
