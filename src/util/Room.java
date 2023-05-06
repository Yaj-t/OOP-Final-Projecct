/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Predator
 */
public class Room {
    private int roomID;
    private String roomNumber;
    private double price;
    private String description;

    public Room(int roomID, String roomNumber, double price, String description) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.description = description;
    }

    public Room(String roomNumber, double price, String description) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
   
    
    
}
