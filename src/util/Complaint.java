package util;

import java.time.LocalDate;

/**

A Complaint class that represents a complaint submitted by a user regarding a room issue.
*/
public class Complaint {
    private int complaintId;
    private int roomId;
    private LocalDate date;
    private String description;
    private Status status;

    /**
     * Constructs a new Complaint object with specified complaint ID, room ID,
     * complaint date, description and status.
     *
     * @param complaintId the unique ID of the complaint
     * @param roomId the ID of the room associated with the complaint
     * @param complaintDate the date when the complaint was submitted
     * @param description the description of the complaint
     * @param status the status of the complaint
     */
    public Complaint(int complaintId, int roomId, LocalDate complaintDate, String description, Status status) {
        this.complaintId = complaintId;
        this.roomId = roomId;
        this.date = complaintDate;
        this.description = description;
        this.status = status;
    }

    /**
     * Constructs a new Complaint object with specified room ID, complaint date,
     * description and status.
     *
     * @param roomId the ID of the room associated with the complaint
     * @param date the date when the complaint was submitted
     * @param description the description of the complaint
     * @param status the status of the complaint
     */
    public Complaint(int roomId, LocalDate date, String description, Status status) {
        this.roomId = roomId;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    /**
     * Returns the complaint ID of this Complaint object.
     *
     * @return the complaint ID
     */
    public int getComplaintId() {
        return complaintId;
    }

    /**
     * Sets the complaint ID of this Complaint object.
     *
     * @param complaintId the complaint ID to set
     */
    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    /**
     * Returns the room ID of this Complaint object.
     *
     * @return the room ID
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the room ID of this Complaint object.
     *
     * @param roomId the room ID to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Returns the complaint date of this Complaint object.
     *
     * @return the complaint date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the complaint date of this Complaint object.
     *
     * @param date the complaint date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the description of this Complaint object.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this Complaint object.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the status of this Complaint object.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of this Complaint object.
     *
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * An enum representing the status of a Complaint object.
     */
    public enum Status {
        RESOLVED,
        UNRESOLVED
    }
}

