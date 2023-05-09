package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Payment;

public class Payments {

    // Get all payments
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

    // Get all payments by rental id
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

    // Get all payments by employee id
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

    // Add payment
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

    // Check if Rental has been paid
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

}
