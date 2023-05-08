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

    public EmployeeLogs(){
    }

    // Create Employee Action Log
    public static void createEmployeeActionLog(EmployeeActionLog employeeActionLog) throws SQLException {
        String sql = "INSERT INTO employee_action_log (employee_id, action, action_time) VALUES (?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, employeeActionLog.getuser_id());
            statement.setString(2, employeeActionLog.getActionDescription());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(employeeActionLog.getActionTime()));
            statement.executeUpdate();
        }
    }

    // Create Employee Login Log
    public static void createEmployeeLoginLog(EmployeeLoginLogs employeeLoginLogs) throws SQLException {
        String sql = "INSERT INTO employee_login_log (employee_id, log_type, log_time) VALUES (?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, employeeLoginLogs.getuser_id());
            statement.setString(2, employeeLoginLogs.getType().toString());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(employeeLoginLogs.getLogTime()));
            statement.executeUpdate();
        }
    }

    // Get All Employee Action Logs
    public static List<EmployeeActionLog> getAllEmployeeActionLogs() throws SQLException {
        List<EmployeeActionLog> employeeActionLogs = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_action_log");

            while (resultSet.next()) {
                EmployeeActionLog employeeActionLog = new EmployeeActionLog(
                        resultSet.getInt("log_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("action"),
                        resultSet.getTimestamp("action_time").toLocalDateTime()
                );
                employeeActionLogs.add(employeeActionLog);
            }
        }
        Connect.closeConnection();
        return employeeActionLogs;
    }

    // Get All Employee Login Logs
    public static List<EmployeeLoginLogs> getAllEmployeeLoginLogs() throws SQLException {
        List<EmployeeLoginLogs> employeeLoginLogs = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
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
        }
        return employeeLoginLogs;
    }

    // Helper method to get the connection object
    private static Connection getConnection() throws SQLException {
        if (connection == null) {
            // Establish the connection here
            connection = Connect.connectToDatabase();
        }
        return connection;
    }
}
