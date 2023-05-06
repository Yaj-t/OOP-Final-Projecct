package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Booking;

public class BookingDAO {
    
    private static Connection connection;
   

    // Static function to add a new booking to the database
    public static boolean addBooking(Booking booking) throws SQLException {
        connection = Connect.connectToDatabase();
   
        try {
            // Prepare the SQL statement with placeholders for values
            String sql = "INSERT INTO bookings (tenant_id, check_in_date, check_out_date, total_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Set the values for the placeholders in the SQL statement
            statement.setInt(1, booking.getTenantId());
            statement.setDate(2, Date.valueOf(booking.getCheckInDate()));
            statement.setDate(3, Date.valueOf(booking.getCheckOutDate()));
            statement.setDouble(4, booking.getTotalAmount());
            
            // Execute the SQL statement and check the number of rows affected
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Connect.closeConnection();
        }
        return false;
    }
    
    // Static function to update an existing booking in the database
    public static boolean updateBooking(Booking booking) throws SQLException {  
        connection = Connect.connectToDatabase();
        try {
            // Prepare the SQL statement with placeholders for values
            String sql = "UPDATE bookings SET tenant_id = ?, check_in_date = ?, check_out_date = ?, total_amount = ? WHERE booking_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Set the values for the placeholders in the SQL statement
            statement.setInt(1, booking.getTenantId());
            statement.setDate(2, Date.valueOf(booking.getCheckInDate()));
            statement.setDate(3, Date.valueOf(booking.getCheckOutDate()));
            statement.setDouble(4, booking.getTotalAmount());
            statement.setInt(5, booking.getId());
            
            // Execute the SQL statement and check the number of rows affected
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Connect.closeConnection();
        }
  
        return false;
    }
    
    // Static function to delete a booking from the database
    public static boolean deleteBooking(int id) throws SQLException {
         connection = Connect.connectToDatabase();
         
        try {
            // Prepare the SQL statement with placeholders for values
            String sql = "DELETE FROM bookings WHERE booking_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Set the values for the placeholders in the SQL statement
            statement.setInt(1, id);
            
            // Execute the SQL statement and check the number of rows affected
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Connect.closeConnection();
        }
        return false;
    }
    
    // Static function to retrieve a booking from the database by ID
    public static Booking getBookingById(int id) throws SQLException {
        connection = Connect.connectToDatabase();
        try {
            // Prepare the SQL statement with placeholders for values
            String sql = "SELECT * FROM bookings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Set the values for the placeholders in the SQL statement
            statement.setInt(1, id);
            
            // Execute the SQL statement and retrieve the results
            ResultSet result = statement.executeQuery();
            
            // If there is a result, create a new Booking object and return it
            if (result.next()){
                Booking booking = new Booking();
                booking.setId(result.getInt("id"));
                booking.setTenantId(result.getInt("tenant_id"));
                booking.setCheckInDate(result.getDate("check_in_date").toLocalDate());
                booking.setCheckOutDate(result.getDate("check_out_date").toLocalDate());
                booking.setTotalAmount(result.getDouble("total_amount"));
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Connect.closeConnection();
        }
        return null;
    }

// Static function to retrieve all bookings from the database
    public static List<Booking> getAllBookings() throws SQLException {
        connection = Connect.connectToDatabase();
        List<Booking> bookings = new ArrayList<>();
        try {
            // Prepare the SQL statement
            String sql = "SELECT * FROM bookings";
            Statement statement = connection.createStatement();

            // Execute the SQL statement and retrieve the results
            ResultSet result = statement.executeQuery(sql);

            // Create a new Booking object for each result and add it to the list
            while (result.next()) {
                Booking booking = new Booking();
                booking.setId(result.getInt("id"));
                booking.setTenantId(result.getInt("tenant_id"));
                booking.setCheckInDate(result.getDate("check_in_date").toLocalDate());
                booking.setCheckOutDate(result.getDate("check_out_date").toLocalDate());
                booking.setTotalAmount(result.getDouble("total_amount"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Connect.closeConnection();
        }
        return bookings;
    }

// Static function to retrieve all bookings for a specific tenant from the database
    public static List<Booking> getBookingsByTenantId(int tenantId) throws SQLException {
        connection = Connect.connectToDatabase();
        List<Booking> bookings = new ArrayList<>();
        try {
            // Prepare the SQL statement with placeholders for values
            String sql = "SELECT * FROM bookings WHERE tenant_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values for the placeholders in the SQL statement
            statement.setInt(1, tenantId);

            // Execute the SQL statement and retrieve the results
            ResultSet result = statement.executeQuery();

            // Create a new Booking object for each result and add it to the list
            while (result.next()) {
                Booking booking = new Booking();
                booking.setId(result.getInt("id"));
                booking.setTenantId(result.getInt("tenant_id"));
                booking.setCheckInDate(result.getDate("check_in_date").toLocalDate());
                booking.setCheckOutDate(result.getDate("check_out_date").toLocalDate());
                booking.setTotalAmount(result.getDouble("total_amount"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Connect.closeConnection();
        }
        return bookings;
    }
}
