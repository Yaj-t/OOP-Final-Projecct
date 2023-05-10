package util;

import java.time.LocalDateTime;

/**
 *
 * The ActionLog class represents a log of an action performed by a user in the
 * system.
 *
 * Each ActionLog object contains information about the action such as its
 * description, the ID of the user who performed the action,
 *
 * and the time when the action was performed.
 *
 * This class also provides methods for setting and getting the values of these
 * attributes.
 */
public class ActionLog {

    // Attributes
    private int logId;
    private int user_id;
    private String actionDescription;
    private LocalDateTime actionTime;

    /**
     *
     * Default constructor for creating an empty ActionLog object.
     */
    public ActionLog() {
    }

     /**
     *
     * Constructor for creating an ActionLog object with the specified
     * attributes.
     *
     * @param logId the ID of the log entry
     * @param user_id the ID of the user who performed the action
     * @param actionDescription a description of the action performed
     * @param actionTime the time when the action was performed
     */
    public ActionLog(int logId, int user_id, String actionDescription, LocalDateTime actionTime) {
        this.logId = logId;
        this.user_id = user_id;
        this.actionDescription = actionDescription;
        this.actionTime = actionTime;
    }

    /**
     *
     * Constructor for creating an ActionLog object with the specified user ID
     * and action description. The log ID is set to 0 and the action time is set
     * to the current time.
     *
     * @param user_id the ID of the user who performed the action
     * @param actionDescription a description of the action performed
     */
    public ActionLog(int user_id, String actionDescription) {
        this.logId = 0;
        this.user_id = user_id;
        this.actionDescription = actionDescription;
        this.actionTime = LocalDateTime.now();
    }
    // Getter and Setter

    /**
     *
     * Returns the ID of the log entry.
     *
     * @return the log ID
     */
    public int getLogId() {
        return this.logId;
    }

    /**
     *
     * Sets the ID of the log entry.
     *
     * @param logId the log ID to set
     */
    public void setLogId(int logId) {
        this.logId = logId;
    }

    /**
     *
     * Returns the ID of the user who performed the action.
     *
     * @return the user ID
     */
    public int getuser_id() {
        return this.user_id;
    }

    /**
     *
     * Sets the ID of the user who performed the action.
     *
     * @param user_id the user ID to set
     */
    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     *
     * Returns the description of the action performed.
     *
     * @return the action description
     */
    public String getActionDescription() {
        return this.actionDescription;
    }

    /**
     *
     * Sets the description of the action performed.
     *
     * @param actionDescription the action description to set
     */
    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    /**
     *
     * Returns the time when the action was performed.
     *
     * @return the action time
     */
    public LocalDateTime getActionTime() {
        return this.actionTime;
    }
    
}
