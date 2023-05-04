/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package room;
import enums.RoomStatus;
import enums.RoomType;

/**
 *
 * @author Predator
 */
public class Room {
    private int roomID;
    private String roomNumber;
    private float price;
    private int maxGuest;
    private int currentOccupancy;
    private RoomStatus status;

    public Room(int roomID, String roomNumber, float price, int maxGuest, int currentOccupancy, RoomStatus status) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.maxGuest = maxGuest;
        this.currentOccupancy = currentOccupancy;
        this.status = status;
    }
    
    public Room(String roomNumber, float price, int maxGuest, int currentOccupancy, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.maxGuest = maxGuest;
        this.currentOccupancy = currentOccupancy;
        this.status = status;
    }
    
    public int getRoomID() {
        return roomID;
    }
    

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxOccupancy) {
        this.maxGuest = maxOccupancy;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    
   
    
    
}
