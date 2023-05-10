/**
 * The Connect class is responsible for establishing a connection to the database
 * and closing it when the application terminates.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
    static Connection connection = null;

     /**
     * Constructor that calls the connectToDatabase method to initialize the database connection.
     * @throws SQLException if a database access error occurs
     */
    public Connect() throws SQLException {
        // Initialize database connection
        connectToDatabase();
    }
   
    /**
     * Establishes a connection to the database.
     * If a connection has already been established, this method will return it instead of creating a new one.
     * @return a Connection object representing the database connection
     * @throws SQLException if a database access error occurs
     */
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
    
     /**
     * Closes the database connection.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected");
            } catch (SQLException e) {
                System.out.println("Disconnection Failed");
            }
            connection = null;
        }
    }
}
