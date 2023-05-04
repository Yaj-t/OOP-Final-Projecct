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
public class DoubleRoom extends Room {

    public DoubleRoom(int roomID, String roomNumber, float price, int maxGuest, int currentOccupancy, RoomStatus status) {
        super(roomID, roomNumber, price, maxGuest, currentOccupancy, status);
    }

    public DoubleRoom(String roomNumber, float price, int maxGuest, int currentOccupancy, RoomStatus status) {
        super(roomNumber, price, maxGuest, currentOccupancy, status);
    }
  
   
  
   
   
    
}
