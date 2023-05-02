/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package room;

import enums.RoomStatus;
import enums.RoomType;

/**
 *
 * @author T-jay
 */
public class SuiteRoom extends Room {
  
    public SuiteRoom(int roomID, String roomNumber, RoomType roomtype, float price, int maxGuest, int currentOccupancy, RoomStatus status) {
        super(roomID, roomNumber, roomtype, price, maxGuest, currentOccupancy, status);
    }
  
  
    
}
