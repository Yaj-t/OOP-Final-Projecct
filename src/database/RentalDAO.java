/**
 * A class that provides methods to interact with the rentals table in the database.
 */
package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Rental;

public class RentalDAO {
    
    private static Connection connection;

    /**
     * Adds a new rental to the database.
     *
     * @param rental the Rental object to add to the database.
     * @return true if the rental was added successfully, false otherwise.
     * @throws SQLException if there was an error executing the SQL statement.
     */
public static boolean addRental(Rental rental) throws SQLException {
    connection = Connect.connectToDatabase();
    try {
        // Prepare the SQL statement with placeholders for the values
        String sql = "INSERT INTO rentals (tenant_id, user_id, room_id, check_in_date, check_out_date, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the values of the placeholders
        statement.setInt(1, rental.getTenant_id());
        statement.setInt(2, rental.getUser_id());
        statement.setInt(3, rental.getRoom_id());
        statement.setDate(4, Date.valueOf(rental.getCheck_in_date()));
        statement.setDate(5, Date.valueOf(rental.getCheck_out_date()));
        statement.setDouble(6, rental.getTotal_amount());
        
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


    /**
     * Updates an existing rental in the database.
     *
     * @param rental the Rental object to update in the database.
     * @return true if the rental was updated successfully, false otherwise.
     * @throws SQLException if there was an error executing the SQL statement.
     */
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

    /**
     * Deletes an existing rental from the database.
     *
     * @param rental_id the ID of the rental to delete from the database.
     * @return true if the rental was deleted successfully, false otherwise.
     * @throws SQLException if there was an error executing the SQL statement.
     */
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

    /**
     * Retrieves a rental from the database.
     *
     * @param rental_id the ID of the rental to retrieve from the database.
     * @return the Rental object if it exists in the database, null otherwise.
     * @throws SQLException if there was an error executing the SQL statement.
     */
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

    /**
     * Retrieves all rentals from the database.
     *
     * @return a list of all Rental objects in the database.
     * @throws SQLException if there was an error executing the SQL statement.
     */
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

    /**
     *
     * Retrieves all rentals from the database for a specific tenant.
     *
     * @param tenant_id the ID of the tenant to retrieve rentals for
     * @return a list of Rental objects representing the rentals for the given
     * tenant
     * @throws SQLException if an error occurs while accessing the database
     */
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

    /**
    * Retrieves all rentals for a given room ID from the database.
    *
    * @param roomId the ID of the room for which to retrieve rentals
    * @return a List of Rental objects representing the rentals associated with the given room ID
    * @throws SQLException if there is an error accessing the database
    */
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

    /**
    * Retrieves all active rentals, i.e. rentals where the check out date is in the future
    *   compared to the current date.
    *
    * @return a List of Rental objects representing the active rentals
    * @throws SQLException if there is an error accessing the database
    */
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


    /**
    * Retrieves all past rentals, i.e. rentals where the check out date is in the past compared
    * to the current date.
    *
    * @return a List of Rental objects representing the past rentals
    * @throws SQLException if there is an error accessing the database
    */
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

    /**
    * Updates the total amount owed for a rental by subtracting the specified amount paid from the
     * rental's total amount.
     *
     * @param rentalId the ID of the rental to be updated
     * @param amountPaid the amount paid towards the rental
     * @throws SQLException if there is an error accessing the database
     */

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


    /**

    Updates the total amount due for a rental by subtracting the specified amount paid

    @param rentalId The ID of the rental to update

    @param amountPaid The amount paid towards the rental

    @throws SQLException If an error occurs while accessing the database
    */
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

    /**

Retrieves the total amount due for a rental

@param rentalId The ID of the rental to retrieve the amount for

@return The total amount due for the rental

@throws SQLException If an error occurs while accessing the database
*/ 
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