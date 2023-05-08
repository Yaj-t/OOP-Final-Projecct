package util;
import java.time.LocalDateTime;
import enums.LogType;

public class AdminLoginLogs extends LoginLogs{

    //Constructor
    public AdminLoginLogs() {
    }

    public AdminLoginLogs(int logId, int employeeId, LogType type, LocalDateTime logTime) {
        super(logId, employeeId, type, logTime);
    }
}
