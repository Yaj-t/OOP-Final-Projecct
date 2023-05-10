
/**
The AdminLogs class provides methods to interact with the admin_action_log and admin_login_log tables in the database.
*/

package database;

import enums.LogType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.AdminActionLog;
import util.AdminLoginLogs;

public class AdminLogs {
    /**
     * Creates a new admin action log in the admin_action_log table.
     *
     * @param adminActionLog The AdminActionLog object to be inserted into the
     * table.
     * @throws SQLException if there is an error while accessing the database.
     */
    public static void createAdminActionLog(AdminActionLog adminActionLog) throws SQLException {
        String sql = "INSERT INTO admin_action_log (admin_id, action_description, action_time) VALUES (?, ?, ?)";
        
        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, adminActionLog.getuser_id());
            statement.setString(2, adminActionLog.getActionDescription());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(adminActionLog.getActionTime()));
            statement.executeUpdate();
        }finally {
        	Connect.closeConnection();
        }      
    }
    
    /**
     * Creates a new admin login log in the admin_login_log table.
     *
     * @param adminLoginLogs The AdminLoginLogs object to be inserted into the
     * table.
     * @throws SQLException if there is an error while accessing the database.
     */
    public static void createAdminLoginLog(AdminLoginLogs adminLoginLogs) throws SQLException {
        String sql = "INSERT INTO admin_login_log (admin_id, log_type, log_time) VALUES (?, ?, ?)";

        try (Connection connection = Connect.connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, adminLoginLogs.getuser_id());
            statement.setString(2, adminLoginLogs.getType().toString());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(adminLoginLogs.getLogTime()));
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    /**
     * Retrieves all admin action logs from the admin_action_log table.
     *
     * @return A List of AdminActionLog objects containing the log data.
     * @throws SQLException if there is an error while accessing the database.
     */
    public static List<AdminActionLog> getAllAdminActionLogs() throws SQLException {
        List<AdminActionLog> adminActionLogs = new ArrayList<>();
        try (Connection connection = Connect.connectToDatabase();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM admin_action_log")) {

            while (resultSet.next()) {
                AdminActionLog adminActionLog = new AdminActionLog(
                        resultSet.getInt("log_id"),
                        resultSet.getInt("admin_id"),
                        resultSet.getString("action_description"),
                        resultSet.getTimestamp("action_time").toLocalDateTime()
                );
                adminActionLogs.add(adminActionLog);
            }
        }
        Connect.closeConnection();
        return adminActionLogs;
    }

    /**
     * Retrieves all admin login logs from the admin_login_log table.
     *
     * @return A List of AdminLoginLogs objects containing the log data.
     * @throws SQLException if there is an error while accessing the database.
     */
    public static List<AdminLoginLogs> getAllAdminLoginLogs() throws SQLException {
        List<AdminLoginLogs> adminLoginLogs = new ArrayList<>();
        try (Connection connection = Connect.connectToDatabase();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM admin_login_log")) {

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
        // Connection will be automatically closed here
        Connect.closeConnection();
        return adminLoginLogs;
    }
}
