package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Expense;

/**
 *
 * This class represents a data access object (DAO) for the Expense model, which provides methods for
 * CRUD operations (Create, Read, Update, Delete) on expenses in the database.
 */
public class ExpenseDAO {
    
    private static Connection connection;
    
    public ExpenseDAO() throws SQLException {
        // Initialize database connection
    }
    
    /**
     *
     * Adds a new expense to the database.
     *
     * @param expense The Expense object to be added to the database.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static void addExpense(Expense expense) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "INSERT INTO expenses (amount, expense_date, description, user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, expense.getAmount());
        statement.setDate(2,   java.sql.Date.valueOf(expense.getDate()));
        statement.setString(3, expense.getDescription());
        statement.setInt(4, expense.getUser_id());
        statement.executeUpdate();
        Connect.closeConnection();
    }
    
    /**
     *
     * Updates an existing expense in the database.
     *
     * @param expense The Expense object to be updated in the database.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static void updateExpense(Expense expense) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "UPDATE expenses SET amount = ?, expense_date = ?, description = ? WHERE expense_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, expense.getAmount());
        statement.setDate(2, java.sql.Date.valueOf(expense.getDate()));
        statement.setString(3, expense.getDescription());
        statement.setInt(4, expense.getId());
        statement.executeUpdate();
        Connect.closeConnection();
    }
    
    /**
     *
     * Deletes an expense from the database by its ID.
     *
     * @param expenseId The ID of the expense to be deleted from the database.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static void deleteExpense(int expenseId) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM expenses WHERE expense_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, expenseId);
        statement.executeUpdate();
        Connect.closeConnection();
    }
    
    /**
     *
     * Retrieves all expenses from the database.
     *
     * @return A List of Expense objects representing all expenses in the
     * database.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static  List<Expense> getAllExpenses() throws SQLException {
        connection = Connect.connectToDatabase();
        System.out.println("here");
        String sql = "SELECT * FROM expenses";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<Expense> expenses = new ArrayList<>();
        while (result.next()) {
            Expense expense = new Expense();
            expense.setId(result.getInt("expense_id"));
            expense.setUser_id(result.getInt("user_id"));
            expense.setAmount(result.getDouble("amount"));
            expense.setDate(result.getDate("expense_date").toLocalDate());
            expense.setDescription(result.getString("description"));
            expenses.add(expense);
        }   
        Connect.closeConnection();
        return expenses;
    }
    
    /**
     *
     * Retrieves an expense from the database by its ID.
     *
     * @param expenseId The ID of the expense to retrieve from the database.
     * @return The Expense object with the specified ID, or null if no such
     * expense exists in the database.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static Expense getExpenseById(int expenseId) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM expenses WHERE expense_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, expenseId);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            Expense expense = new Expense();
            expense.setId(result.getInt("expense_id"));
            expense.setUser_id(result.getInt("user_id"));
            expense.setAmount(result.getDouble("amount"));
            expense.setDate(result.getDate("expense_date").toLocalDate());
            expense.setDescription(result.getString("description"));
            return expense;
        }
        Connect.closeConnection();
        return null;
    }
}
