/**

The EmployeeActionLog class represents the action log of an employee.
It extends the ActionLog class.
*/
package util;

import java.time.LocalDateTime;


//Extends to action log
public class EmployeeActionLog extends ActionLog {
    //Constructor
    public EmployeeActionLog() {
    }
/**
 * Creates a new instance of EmployeeActionLog with the given parameters.
 * 
 * @param logId the ID of the action log
 * @param employeeId the ID of the employee
 * @param actionDescription the description of the action
 * @param actionTime the time of the action
 */
    public EmployeeActionLog(int logId, int employeeId, String actionDescription, LocalDateTime actionTime) {
        super(logId, employeeId, actionDescription, actionTime);
    }
/**
 * Creates a new instance of EmployeeActionLog with the given parameters.
 * The log ID is set to 0 by default.
 * 
 * @param employeeId the ID of the employee
 * @param actionDescription the description of the action
 */
    public EmployeeActionLog(int employeeId, String actionDescription) {
        super(employeeId, actionDescription);
    }
}