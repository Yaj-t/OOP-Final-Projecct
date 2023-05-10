
package util;
import java.time.LocalDateTime;

/**
 *
 * Represents an action log of an administrator.
 */

public class AdminActionLog extends ActionLog{
    //Constructor   
    public AdminActionLog() {
    }
    
    /**
 * Constructs a new instance of an AdminActionLog with the given parameters.
 *
 * @param logId the unique identifier for the log
 * @param employeeId the unique identifier for the employee
 * @param actionDescription the description of the action performed
 * @param actionTime the date and time when the action was performed
 */
    public AdminActionLog(int logId, int employeeId, String actionDescription, LocalDateTime actionTime) {
        super(logId, employeeId, actionDescription, actionTime);
    }

    /**
     * Constructs a new instance of an AdminActionLog with the given parameters.
     *
     * @param employeeId the unique identifier for the employee
     * @param actionDescription the description of the action performed
     */
    public AdminActionLog(int employeeId, String actionDescription) {
        super(employeeId, actionDescription);
    }

}
