package util;
import java.time.LocalDateTime;

public class AdminActionLog extends ActionLog{
    //Constructor
    public AdminActionLog() {
    }

    public AdminActionLog(int logId, int employeeId, String actionDescription, LocalDateTime actionTime) {
        super(logId, employeeId, actionDescription, actionTime);
    }

}
