package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Payment;

/**
 *
 * This class handles database operations related to payments.
 */
public class PaymentDAO {

    /**
     * Gets all payments from the database.
     *
     * @return a list of Payment objects representing all payments in the
     * database
     */
    public static List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try (Connection connection = Connect.connectToDatabase();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM payments")) {

            while (resultSet.next()) {
                Payment payment = new Payment(
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("rental_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("payment_date").toLocalDate(),
                        resultSet.getString("description")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all payments: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
        return payments;
    } 

    /**
     * Gets all payments from the database associated with a specific rental.
     *
     * @param rentalId the ID of the rental to get payments for
     * @return a list of Payment objects representing all payments for the
     * specified rental
     */
    public static List<Payment> getAllPaymentsByRentalId(int rentalId) {
        List<Payment> payments = new ArrayList<>();
        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM payments WHERE rental_id = ?")) {
            statement.setInt(1, rentalId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Payment payment = new Payment(
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("rental_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("payment_date").toLocalDate(),
                        resultSet.getString("description")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all payments by rental id: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
        return payments;
    }

    /**
     * Gets all payments from the database associated with a specific employee.
     *
     * @param employeeId the ID of the employee to get payments for
     * @return a list of Payment objects representing all payments made by the
     * specified employee
     */
    public static List<Payment> getAllPaymentsByEmployeeId(int employeeId) {
        List<Payment> payments = new ArrayList<>();
        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM payments WHERE employee_id = ?")) {
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Payment payment = new Payment(
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("rental_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("payment_date").toLocalDate(),
                        resultSet.getString("description")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all payments by employee id: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
        return payments;
    }

    /**
     * Adds a payment to the database.
     *
     * @param payment the Payment object to add to the database
     */
    public static void addPayment(Payment payment) {
        String sql = "INSERT INTO payments (rental_id, employee_id, amount, payment_date, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, payment.getRental_id());
            statement.setInt(2, payment.getEmployee_id());
            statement.setDouble(3, payment.getAmount());
            statement.setDate(4, Date.valueOf(payment.getPayment_date()));
            statement.setString(5, payment.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding payment: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
    }

    /**
     * Deletes a payment from the database.
     *
     * @param paymentId the ID of the payment to delete
     */
    public static void deletePayment(int paymentId) {
        String sql = "DELETE FROM payments WHERE payment_id = ?";

        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paymentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting payment: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
    }

    /**
     * Updates a payment in the database.
     * @param payment
    */
    public static void updatePayment(Payment payment) {
        String sql = "UPDATE payments SET rental_id = ?, employee_id = ?, amount = ?, payment_date = ?, description = ? WHERE payment_id = ?";

        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, payment.getRental_id());
            statement.setInt(2, payment.getEmployee_id());
            statement.setDouble(3, payment.getAmount());
            statement.setDate(4, Date.valueOf(payment.getPayment_date()));
            statement.setString(5, payment.getDescription());
            statement.setInt(6, payment.getPayment_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating payment: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
    }


    /**
     * Checks if a rental has been paid.
     *
     * @param rentalId the ID of the rental to check
     * @return true if the rental has been paid, false otherwise
     */
    public static boolean isRentalPaid(int rentalId) {
        boolean isPaid = false;
        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM payments WHERE rental_id = ?")) {
            statement.setInt(1, rentalId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                isPaid = true;
            }
        } catch (SQLException e) {
            System.out.println("Error checking if rental has been paid: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
        return isPaid;
    }

    /**
     * Gets Payment from payment_id
     * @param paymentId
     * @return Payment
     */
     public static Payment getPaymetnByID(int paymentId) {
        Payment payment = null;
        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM payments WHERE payment_id = ?")) {
            statement.setInt(1, paymentId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                payment = new Payment(
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("rental_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("payment_date").toLocalDate(),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error getting payment by id: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
        return payment;
    }


    /**
     * Gets rental_id then deletes all payments associated with that rental_id
     * @param rentalId
     */
     public static void deleteAllPaymentsByRentalId(int rentalId) {
        String sql = "DELETE FROM payments WHERE rental_id = ?";

        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rentalId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting payment: " + e.getMessage());
        }finally {
        	Connect.closeConnection();
        }
     }
}
