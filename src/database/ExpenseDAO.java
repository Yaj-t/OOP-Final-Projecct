import database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Expense;

public class ExpenseDAO {
    
    private static Connection connection;
    
    public ExpenseDAO() throws SQLException {
        // Initialize database connection
    }
    
    public static void addExpense(Expense expense) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "INSERT INTO expenses (amount, expense_date, description) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, expense.getAmount());
        statement.setDate(2,   java.sql.Date.valueOf(expense.getDate()));
        statement.setString(3, expense.getDescription());
        statement.executeUpdate();
        Connect.closeConnection();
    }
    
    public void updateExpense(Expense expense) throws SQLException {
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
    
    public void deleteExpense(int expenseId) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM expenses WHERE expense_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, expenseId);
        statement.executeUpdate();
        Connect.closeConnection();
    }
    
    public List<Expense> getAllExpenses() throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM expenses";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<Expense> expenses = new ArrayList<>();
        while (result.next()) {
            Expense expense = new Expense();
            expense.setId(result.getInt("expense_id"));
            expense.setAmount(result.getDouble("amount"));
            expense.setDate(result.getDate("expense_date").toLocalDate());
            expense.setDescription(result.getString("description"));
            expenses.add(expense);
        }
        Connect.closeConnection();
        return expenses;
    }
    
    public Expense getExpenseById(int expenseId) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM expenses WHERE expense_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, expenseId);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            Expense expense = new Expense();
            expense.setId(result.getInt("expense_id"));
            expense.setAmount(result.getDouble("amount"));
            expense.setDate(result.getDate("expense_date").toLocalDate());
            expense.setDescription(result.getString("description"));
            return expense;
        }
        Connect.closeConnection();
        return null;
    }
}
