package util;

import java.time.LocalDateTime;

public class ActionLog {

    // Attributes
    private int logId;
    private int employeeId;
    private String actionDescription;
    private LocalDateTime actionTime;

    // Constructor
    public ActionLog() {
    }

    public ActionLog(int logId, int employeeId, String actionDescription, LocalDateTime actionTime) {
        this.logId = logId;
        this.employeeId = employeeId;
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

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
