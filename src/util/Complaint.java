/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;

/**
 *
 * @author Predator
 */
public class Complaint {
    private int complaintId;
    private int roomId;
    private LocalDate date;
    private String description;
    private Status status;

    public Complaint(int complaintId, int roomId, LocalDate complaintDate, String description, Status status) {
        this.complaintId = complaintId;
        this.roomId = roomId;
        this.date = complaintDate;
        this.description = description;
        this.status = status;
    }

    public Complaint(int roomId, LocalDate date, String description, Status status) {
        this.roomId = roomId;
        this.date = date;
        this.description = description;
        this.status = status;
    }
    
    

    // getter and setter methods
    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        RESOLVED,
        UNRESOLVED
    }
}

