package util;

import java.time.LocalDateTime;

public class ActionLog {

    // Attributes
    private int logId;
    private int user_id;
    private String actionDescription;
    private LocalDateTime actionTime;

    // Constructor
    public ActionLog() {
    }

    public ActionLog(int logId, int user_id, String actionDescription, LocalDateTime actionTime) {
        this.logId = logId;
        this.user_id = user_id;
        this.actionDescription = actionDescription;
        this.actionTime = actionTime;
    }

    // Getter and Setter

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

    public String getActionDescription() {
        return this.actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public LocalDateTime getActionTime() {
        return this.actionTime;
    }
    
}
