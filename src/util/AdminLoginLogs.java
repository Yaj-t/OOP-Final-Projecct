package util;

import java.time.LocalDateTime;
import enums.LogType;

/**
 *
 * The AdminLoginLogs class is a subclass of LoginLogs that represents login
 * logs made by an admin user.
 */
public class AdminLoginLogs extends LoginLogs{

    //Constructor
    public AdminLoginLogs() {
    }

/**
 * Constructor for AdminLoginLogs class that takes log id, employee id, log type, and log time as parameters.
 * @param logId The unique identifier for this login log.
 * @param employeeId The id of the admin employee who made this login.
 * @param type The type of the login.
 * @param logTime The date and time when the login was made.
 */ 
    public AdminLoginLogs(int logId, int employeeId, LogType type, LocalDateTime logTime) {
        super(logId, employeeId, type, logTime);
    }

/**
 * Constructor for AdminLoginLogs class that takes employee id and log type as parameters.
 * The log time will be set to the current date and time.
 * @param employeeId The id of the admin employee who made this login.
 * @param type The type of the login.
 */
    public AdminLoginLogs(int employeeId, LogType type) {
        super(employeeId, type);
    }
}
