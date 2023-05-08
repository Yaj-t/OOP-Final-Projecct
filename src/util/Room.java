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
    private int id;
    private String roomNumber;
    private double price;
    private String description;

    public Room(){
        
    }
    
    public Room(String roomNumber, double price, String description) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.description = description;
    }

    public Room(int id, String roomNumber, double price, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.price = price;
        this.description = description;
    }

    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
