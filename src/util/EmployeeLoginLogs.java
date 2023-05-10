
package util;

import java.time.LocalDateTime;
import enums.LogType;

/**
 * The EmployeeLoginLogs class extends the LoginLogs class and represents the
 * login logs of an employee.
 */
public class EmployeeLoginLogs extends LoginLogs {
    //Constructor
    
    public EmployeeLoginLogs() {
    }
    /**
     * Constructs a new instance of EmployeeLoginLogs with the specified values
     * for its attributes.
     *
     * @param logId the ID of the login log
     * @param employeeId the ID of the employee
     * @param type the type of the login log
     * @param logTime the time of the login log
     */
    public EmployeeLoginLogs(int logId, int employeeId, LogType type, LocalDateTime logTime) {
        super(logId, employeeId, type, logTime);
    }
    /**
     * Constructs a new instance of EmployeeLoginLogs with the specified values
     * for its attributes.
     *
     * @param employeeId the ID of the employee
     * @param type the type of the login log
     */
    public EmployeeLoginLogs(int employeeId, LogType type) {
        super(employeeId, type);
    }
}
