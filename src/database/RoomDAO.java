/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author Predator
 */
import enums.RoomStatus;
import enums.RoomType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import room.Room;

public class RoomDAO {
    private static Connection connection;

    public RoomDAO() {
        if(Connect.connection == null){
            try {
                Connect.connectToDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Connect.closeConnection();
    }

    public static void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (room_number, roomtype, room_price, max_guest, current_occupancy, status) VALUES (?, ?, ?, ?, ?, ?)";
        connection = Connect.connectToDatabase();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, room.getRoomNumber());
            statement.setString(2, room.getRoomtype().toString());
            statement.setFloat(3, room.getPrice());
            statement.setInt(4, room.getMaxGuest());
            statement.setInt(5, room.getCurrentOccupancy());
            statement.setString(6, room.getStatus().toString());
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    public static List<Room> getAllRooms() throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rooms";
        List<Room> rooms = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int roomID = resultSet.getInt("room_id");
                String roomNumber = resultSet.getString("room_number");
                RoomType roomtype = RoomType.valueOf(resultSet.getString("roomtype"));
                float price = resultSet.getFloat("room_price");
                int maxGuest = resultSet.getInt("max_guest");
                int currentOccupancy = resultSet.getInt("current_occupancy");
                RoomStatus status = RoomStatus.valueOf(resultSet.getString("status"));
                System.out.println(roomID +" "+ roomNumber+" "+ roomtype+" "+ price+" "+ maxGuest+" "+ currentOccupancy+" "+ status);
                Room room = new Room(roomID, roomNumber, roomtype, price, maxGuest, currentOccupancy, status);
                rooms.add(room);
            }
        }
        Connect.closeConnection();
        return rooms;
    }

    public static Room getRoomById(int roomID) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        Room room = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    RoomType roomtype = RoomType.valueOf(resultSet.getString("roomtype"));
                    String roomNumber =resultSet.getString("room_number");
                    int price = resultSet.getInt("room_price");
                    int maxGuest = resultSet.getInt("max_guest");
                    int currentOccupancy = resultSet.getInt("current_occupancy");
                    RoomStatus status = RoomStatus.valueOf(resultSet.getString("status"));

                    room = new Room(roomID, roomNumber, roomtype, price, maxGuest, currentOccupancy, status);
                }
            }
        }
        Connect.closeConnection();  
        return room;
    }

    public static void updateRoom(Room room) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "UPDATE rooms SET roomtype = ?, room_price = ?, max_guest = ?, current_occupancy = ?, status = ?, room_number = ? WHERE room_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, room.getRoomtype().toString());
            statement.setFloat(2, room.getPrice());
            statement.setInt(3, room.getMaxGuest());
            statement.setInt(4, room.getCurrentOccupancy());
            statement.setString(5, room.getStatus().toString());
            statement.setString(6, room.getRoomNumber());
            statement.setInt(7, room.getRoomID());
            statement.executeUpdate();
        }
       Connect.closeConnection();
    }

    public static void deleteRoom(int roomID) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM rooms WHERE room_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            statement.executeUpdate();
        }
       Connect.closeConnection();
    }
}

