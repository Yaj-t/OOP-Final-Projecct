package util;
import java.time.LocalDateTime;


//Extends to action log
public class EmployeeActionLog extends ActionLog {
    //Constructor
    public EmployeeActionLog() {
    }

    public EmployeeActionLog(int logId, int employeeId, String actionDescription, LocalDateTime actionTime) {
        super(logId, employeeId, actionDescription, actionTime);
    }
}