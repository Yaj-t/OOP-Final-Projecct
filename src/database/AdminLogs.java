package database;

import enums.LogType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.AdminActionLog;
import util.AdminLoginLogs;

public class AdminLogs {

    // Connection
    private static Connection connection;

    public AdminLogs() {
    }

    // Create Admin Action Log
    public static void createAdminActionLog(AdminActionLog adminActionLog) throws SQLException {
        String sql = "INSERT INTO admin_action_log (admin_id, action, action_time) VALUES (?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, adminActionLog.getuser_id());
            statement.setString(2, adminActionLog.getActionDescription());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(adminActionLog.getActionTime()));
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    // Create Admin Login Log
    public static void createAdminLoginLog(AdminLoginLogs adminLoginLogs) throws SQLException {
        String sql = "INSERT INTO admin_login_log (admin_id, log_type, log_time) VALUES (?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, adminLoginLogs.getuser_id());
            statement.setString(2, adminLoginLogs.getType().toString());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(adminLoginLogs.getLogTime()));
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    // Get All Admin Action Logs
    public static List<AdminActionLog> getAllAdminActionLogs() throws SQLException {
        List<AdminActionLog> adminActionLogs = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin_action_log");

            while (resultSet.next()) {
                AdminActionLog adminActionLog = new AdminActionLog(
                        resultSet.getInt("log_id"),
                        resultSet.getInt("admin_id"),
                        resultSet.getString("action"),
                        resultSet.getTimestamp("action_time").toLocalDateTime()
                );
                adminActionLogs.add(adminActionLog);
            }
        }
        Connect.closeConnection();
        return adminActionLogs;
    }

    // Get All Admin Login Logs
    public static List<AdminLoginLogs> getAllAdminLoginLogs() throws SQLException {
        List<AdminLoginLogs> adminLoginLogs = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin_login_log");

            while (resultSet.next()) {
                AdminLoginLogs adminLoginLog = new AdminLoginLogs(
                        resultSet.getInt("log_id"),
                        resultSet.getInt("admin_id"),
                        LogType.valueOf(resultSet.getString("log_type")),
                        resultSet.getTimestamp("log_time").toLocalDateTime()
                );
                adminLoginLogs.add(adminLoginLog);
            }
        }
        Connect.closeConnection();
        return adminLoginLogs;
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
