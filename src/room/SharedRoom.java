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
public class SharedRoom extends Room {

    public SharedRoom(int roomID, String roomNumber, float price, int maxGuest, int currentOccupancy, RoomStatus status) {
        super(roomID, roomNumber, price, maxGuest, currentOccupancy, status);
    }

}
