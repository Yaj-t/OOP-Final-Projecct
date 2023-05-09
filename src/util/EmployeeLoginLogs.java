package util;
import java.time.LocalDateTime;
import enums.LogType;

public class EmployeeLoginLogs extends LoginLogs {
    //Constructor
    public EmployeeLoginLogs() {
    }

    public EmployeeLoginLogs(int logId, int employeeId, LogType type, LocalDateTime logTime) {
        super(logId, employeeId, type, logTime);
    }

    public EmployeeLoginLogs(int employeeId, LogType type) {
        super(employeeId, type);
    }
}
