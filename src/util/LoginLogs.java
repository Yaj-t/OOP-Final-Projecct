package util;
import java.time.LocalDateTime;
import enums.LogType;


public class LoginLogs {
    //Attributes
    private int logId;
    private int user_id;
    private LogType type;
    private LocalDateTime logTime;

    //Constructor
    public LoginLogs() {
    }

    public LoginLogs(int logId, int user_id, LogType type, LocalDateTime logTime) {
        this.logId = logId;
        this.user_id = user_id;
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

    public int getuser_id() {
        return this.user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
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
