/**

Provides a utility class for handling the closing of a JFrame.
*/
package util;

import enums.LogType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import database.AdminLogs;
import database.EmployeeLogs;
import user.Session;

public class WindowCloseHandler {
/**
 * Adds a window closing listener to the specified JFrame.
 *
 * @param frame The JFrame to add the listener to.
 */
public static void addWindowClosingListener(JFrame frame) {
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            handleWindowClosing();
        }
    });
}

/**
 * Handles the actions when the window is closing.
 */
private static void handleWindowClosing() {
    // Check if the user is Admin or Employee by taking the user type from the session
    if (Session.getCurrentUser().getType() == enums.UserType.ADMIN) {
        createAdminLoginLog(Session.getCurrentUserId(), LogType.LOGOUT);
    } else {
        createEmployeeLoginLog(Session.getCurrentUserId(), LogType.LOGOUT);
    }

    System.exit(0);
}

/**
 * Creates an admin login log.
 *
 * @param userId The ID of the user logging out.
 * @param logType The type of log, either LOGIN or LOGOUT.
 */
private static void createAdminLoginLog(int userId, LogType logType) {
    AdminLoginLogs log = new AdminLoginLogs(userId, logType);
    try {
        AdminLogs.createAdminLoginLog(log);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

/**
 * Creates an employee login log.
 *
 * @param userID The ID of the user logging out.
 * @param logType The type of log, either LOGIN or LOGOUT.
 */
private static void createEmployeeLoginLog(int userID, LogType logType)
{
    EmployeeLoginLogs log = new EmployeeLoginLogs(userID, logType);
    try {
        EmployeeLogs.createEmployeeLoginLog(log);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}