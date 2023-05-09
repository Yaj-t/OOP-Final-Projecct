package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import util.Rental;

public class RentalDAO {
    
    private static Connection connection;

    // Static function to add a new rental to the database
public static boolean addRental(Rental rental) throws SQLException {
    connection = Connect.connectToDatabase();

    try {
        // Prepare the SQL statement with placeholders for the values
        String sql = "INSERT INTO rentals (tenant_id, room_id, check_in_date, check_out_date, total_amount) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql)  ;

        // Set the values of the placeholders
        statement.setInt(1, rental.getTenant_id());
        statement.setInt(2, rental.getRoom_id());
        statement.setDate(3, java.sql.Date.valueOf(rental.getCheck_in_date()));
        statement.setDate(4, java.sql.Date.valueOf(rental.getCheck_out_date()));
        statement.setDouble(5, rental.getTotal_amount());

        // Execute the SQL statement
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new rental was inserted successfully!");
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Connect.closeConnection();
    }
    return false;
}


    // Static function to update a rental in the database
    public static boolean updateRental(Rental rental) throws SQLException {
        connection = Connect.connectToDatabase();

        try { 
            // Prepare the SQL statement with placeholders for the values
            String sql = "UPDATE rentals SET tenant_id = ?, room_id = ?, check_in_date = ?, check_out_date = ?, total_amount = ? WHERE rental_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setInt(1, rental.getTenant_id());
            statement.setInt(2, rental.getRoom_id());
            statement.setDate(3, Date.valueOf(rental.getCheck_in_date()));
            statement.setDate(4, Date.valueOf(rental.getCheck_out_date()));
            statement.setDouble(5, rental.getTotal_amount());
            statement.setInt(6, rental.getRental_id());

            // Execute the SQL statement
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing rental was updated successfully!");
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection();
        }
        return false;
    }

    // Static function to delete a rental from the database
    public static boolean deleteRental(int rental_id) throws SQLException {
        connection = Connect.connectToDatabase();

        try { 
            // Prepare the SQL statement with placeholders for the values
            String sql = "DELETE FROM rentasl WHERE rental_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setInt(1, rental_id);

            // Execute the SQL statement
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An existing rental was deleted successfully!");
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection();
        }
        return false;
    }

    // Static function to get a rental from the database
    public static Rental getRental(int rental_id) throws SQLException {
        connection = Connect.connectToDatabase();

        try { 
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT * FROM rentals WHERE rental_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setInt(1, rental_id);

            // Execute the SQL statement
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                return rental;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection();
        }
        return null;
    }

    // Static function to get all rentals from the database
    public static List<Rental> getAllRentals() throws SQLException{
        connection = Connect.connectToDatabase();
        List<Rental> rentals = new ArrayList<>();
        try {
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT * FROM rentals";
            Statement statement = connection.createStatement();

            // Execute the SQL statement
            ResultSet result = statement.executeQuery(sql);

            // Loop through the results and add them to the list
            while (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
        return rentals;
    }

    // Static function to get all rentals from the database for a specific tenant
    public static List<Rental> getRentalsByTenantsId(int tenant_id) throws SQLException {
        connection = Connect.connectToDatabase();
        List<Rental> rentals = new ArrayList<>();
        try {
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT * FROM rentals WHERE tenant_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setInt(1, tenant_id);

            // Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Loop through the results and add them to the list
            while (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
        return rentals;
    }

    // Static function to get all rentals from the database for a specific room
    public static List<Rental> getRentalsByRoomId(int roomId) throws SQLException{
        connection = Connect.connectToDatabase();
        List<Rental> rentals = new ArrayList<>();
        try {
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT * FROM rentals WHERE room_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setInt(1, roomId);

            // Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Loop through the results and add them to the list
            while (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
        return rentals;
    }

    // Static function to get all rentals where the check out date is far in the future of the current date
   public static List<Rental> getActiveRentals() throws SQLException {
    List<Rental> rentals = new ArrayList<>();
    //Current date
    LocalDate currentDate = LocalDate.now();
    try (Connection connection = Connect.connectToDatabase();
         PreparedStatement statement = connection.prepareStatement(
                 "SELECT * FROM rentals WHERE check_out_date > ? ")) {

        // Set the values of the placeholders
        statement.setDate(1, Date.valueOf(currentDate));

        // Execute the SQL statement
        try (ResultSet result = statement.executeQuery()) {

            // Loop through the results and add them to the list
            while (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                rentals.add(rental);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally{
        Connect.closeConnection();
    }
    return rentals;
}


    // Static function to get all rentals where the check out date is in the past of the current date
    public static List<Rental> getPastRentals() throws SQLException {
        connection = Connect.connectToDatabase();
        List<Rental> rentals = new ArrayList<>();
        //Current date
        LocalDate currentDate = LocalDate.now();
        try {
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT * FROM rentals WHERE check_out_date < ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setDate(1, Date.valueOf(currentDate));

            // Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Loop through the results and add them to the list
            while (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
        return rentals;
    }

    // Get all rentals that are not fully paid

    public static List<Rental> getUnPainRentals() throws SQLException {
        connection = Connect.connectToDatabase();
        List<Rental> rentals = new ArrayList<>();
  
        try { 
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT * FROM rentals WHERE total_amount > 0";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Loop through the results and add them to the list
            while (result.next()) {
                Rental rental = new Rental();
                rental.setRental_id(result.getInt("rental_id"));
                rental.setTenant_id(result.getInt("tenant_id"));
                rental.setRoom_id(result.getInt("room_id"));
                rental.setCheck_in_date(result.getDate("check_in_date").toLocalDate());
                rental.setCheck_out_date(result.getDate("check_out_date").toLocalDate());
                rental.setTotal_amount(result.getDouble("total_amount"));
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
        return rentals;
    }


    // For payments, recieve the rental id and the amount paid
    public static void payRental(int rentalId, double amountPaid) throws SQLException {
        connection = Connect.connectToDatabase();
        try {
            // Prepare the SQL statement with placeholders for the values
            String sql = "UPDATE rentals SET total_amount = total_amount - ? WHERE rental_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setDouble(1, amountPaid);
            statement.setInt(2, rentalId);

            // Execute the SQL statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
    }

    // For payments, recieve the rental id and give the total amount due   
    public static double getRentalAmount(int rentalId) throws SQLException {
        connection = Connect.connectToDatabase();
        double totalAmount = 0;
        try {
            // Prepare the SQL statement with placeholders for the values
            String sql = "SELECT total_amount FROM rentals WHERE rental_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values of the placeholders
            statement.setInt(1, rentalId);

            // Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Loop through the results and add them to the list
            while (result.next()) {
                totalAmount = result.getDouble("total_amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection();
        }
        return totalAmount;
    }


    
}