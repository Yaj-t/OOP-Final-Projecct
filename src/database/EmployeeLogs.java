/**
 *
 * Provides methods to create and retrieve employee action logs and employee login logs from the database.
 */
package database;

import enums.LogType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.EmployeeActionLog;
import util.EmployeeLoginLogs;

public class EmployeeLogs {

    // Connection
    private static Connection connection;

    public EmployeeLogs() {
    }

    /**
     * Creates an employee action log in the database.
     *
     * @param employeeActionLog The EmployeeActionLog object containing
     * information about the employee's action.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static void createEmployeeActionLog(EmployeeActionLog employeeActionLog) throws SQLException {
        String sql = "INSERT INTO employee_action_log (employee_id, action_description, action_time) VALUES (?, ?, ?)";
        connection = Connect.connectToDatabase();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeActionLog.getuser_id());
            statement.setString(2, employeeActionLog.getActionDescription());
            statement.setTimestamp(3, Timestamp.valueOf(employeeActionLog.getActionTime()));
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    /**
     * Creates an employee login log in the database.
     *
     * @param employeeLoginLogs The EmployeeLoginLogs object containing
     * information about the employee's login.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static void createEmployeeLoginLog(EmployeeLoginLogs employeeLoginLogs) throws SQLException {
        String sql = "INSERT INTO employee_login_log (employee_id, log_type, log_time) VALUES (?, ?, ?)";
        connection = Connect.connectToDatabase();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeLoginLogs.getuser_id());
            statement.setString(2, employeeLoginLogs.getType().toString());
            statement.setTimestamp(3, Timestamp.valueOf(employeeLoginLogs.getLogTime()));
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    /**
     * Retrieves a list of all employee action logs from the database.
     *
     * @return A List of EmployeeActionLog objects containing information about
     * each employee action log.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static List<EmployeeActionLog> getAllEmployeeActionLogs() throws SQLException {
        List<EmployeeActionLog> employeeActionLogs = new ArrayList<>();
        connection = Connect.connectToDatabase();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_action_log");

            while (resultSet.next()) {
                EmployeeActionLog employeeActionLog = new EmployeeActionLog(
                        resultSet.getInt("log_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("action_description"),
                        resultSet.getTimestamp("action_time").toLocalDateTime()
                );
                employeeActionLogs.add(employeeActionLog);
            }
        } finally {
            Connect.closeConnection();
        }
        return employeeActionLogs;
    }

    /**
     * Retrieves a list of all employee login logs from the database.
     *
     * @return A List of EmployeeLoginLogs objects containing information about
     * each employee login log.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static List<EmployeeLoginLogs> getAllEmployeeLoginLogs() throws SQLException {
        List<EmployeeLoginLogs> employeeLoginLogs = new ArrayList<>();
        connection = Connect.connectToDatabase();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_login_log");

            while (resultSet.next()) {
                EmployeeLoginLogs employeeLoginLog = new EmployeeLoginLogs(
                        resultSet.getInt("log_id"),
                        resultSet.getInt("employee_id"),
                        LogType.valueOf(resultSet.getString("log_type")),
                        resultSet.getTimestamp("log_time").toLocalDateTime()
                );
                employeeLoginLogs.add(employeeLoginLog);
            }
        } finally {
            Connect.closeConnection();
        }
        return employeeLoginLogs;
    }
}
