package util;
import java.time.LocalDateTime;
import enums.LogType;


public class LoginLogs {
    //Attributes
    private int logId;
    private int employeeId;
    private LogType type;
    private LocalDateTime logTime;

    //Constructor
    public LoginLogs() {
    }

    public LoginLogs(int logId, int employeeId, LogType type, LocalDateTime logTime) {
        this.logId = logId;
        this.employeeId = employeeId;
        this.type = type;
        this.logTime = logTime;
    }

    //Getter and Setter
    
    public int getLogId() {
        return this.logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LogType getType() {
        return this.type;
    }

    public void setType(LogType type) {
        this.type = type;
    }

    public LocalDateTime getLogTime() {
        return this.logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }

}
