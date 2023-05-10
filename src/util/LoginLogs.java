package util;

import java.time.LocalDateTime;
import enums.LogType;

/**
 *
 * The LoginLogs class represents login logs of users. It contains information
 * such as log ID, user ID, log type, and log time.
 */
public class LoginLogs {
    //Attributes
    private int logId;
    private int user_id;
    private LogType type;
    private LocalDateTime logTime;

/**
 * Default constructor for the LoginLogs class.
 */
    public LoginLogs() {
    }

/**
 * Constructor for the LoginLogs class.
 * @param logId the log ID
 * @param user_id the user ID
 * @param type the log type
 * @param logTime the log time
 */
    public LoginLogs(int logId, int user_id, LogType type, LocalDateTime logTime) {
        this.logId = logId;
        this.user_id = user_id;
        this.type = type;
        this.logTime = logTime;
    }

/**
 * Constructor for the LoginLogs class.
 * @param user_id the user ID
 * @param type the log type
 */
    public LoginLogs(int user_id, LogType type) {
        this.logId = 0;
        this.user_id = user_id;
        this.type = type;
        this.logTime = LocalDateTime.now();
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
