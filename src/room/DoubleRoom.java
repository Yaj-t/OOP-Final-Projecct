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
   
    public DoubleRoom(int roomID, RoomType roomtype, int price, int maxGuest, int currentOccupancy, RoomStatus status) {
        super(roomID, roomtype, price, maxGuest, currentOccupancy, status);
    }
   
    
}
