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
   

    public static void connectToDatabase() throws SQLException {
        // Initialize database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomease", "root", "");
        if(connection == null){
            System.out.println("Connection Failed");
        }else{
            System.out.println("Connection Successful");
        }
    }
    
}
