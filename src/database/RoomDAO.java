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
import room.Room;

public class RoomDAO {
    private Connection connection;

    public RoomDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (roomID, roomtype, price, maxGuest, currentOccupancy, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, room.getRoomID());
            statement.setString(2, room.getRoomtype().toString());
            statement.setInt(3, room.getPrice());
            statement.setInt(4, room.getMaxGuest());
            statement.setInt(5, room.getCurrentOccupancy());
            statement.setString(6, room.getStatus().toString());
            statement.executeUpdate();
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        String sql = "SELECT * FROM rooms";
        List<Room> rooms = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int roomID = resultSet.getInt("roomID");
                RoomType roomtype = RoomType.valueOf(resultSet.getString("roomtype"));
                int price = resultSet.getInt("price");
                int maxGuest = resultSet.getInt("maxGuest");
                int currentOccupancy = resultSet.getInt("currentOccupancy");
                RoomStatus status = RoomStatus.valueOf(resultSet.getString("status"));

                Room room = new Room(roomID, roomtype, price, maxGuest, currentOccupancy, status);
                rooms.add(room);
            }
        }

        return rooms;
    }

    public Room getRoomById(int roomID) throws SQLException {
        String sql = "SELECT * FROM rooms WHERE roomID = ?";
        Room room = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    RoomType roomtype = RoomType.valueOf(resultSet.getString("roomtype"));
                    int price = resultSet.getInt("price");
                    int maxGuest = resultSet.getInt("maxGuest");
                    int currentOccupancy = resultSet.getInt("currentOccupancy");
                    RoomStatus status = RoomStatus.valueOf(resultSet.getString("status"));

                    room = new Room(roomID, roomtype, price, maxGuest, currentOccupancy, status);
                }
            }
        }

        return room;
    }

    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE rooms SET roomtype = ?, price = ?, maxGuest = ?, currentOccupancy = ?, status = ? WHERE roomID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, room.getRoomtype().toString());
            statement.setInt(2, room.getPrice());
            statement.setInt(3, room.getMaxGuest());
            statement.setInt(4, room.getCurrentOccupancy());
            statement.setString(5, room.getStatus().toString());
            statement.setInt(6, room.getRoomID());
            statement.executeUpdate();
        }
    }

    public void deleteRoom(int roomID) throws SQLException {
        String sql = "DELETE FROM rooms WHERE roomID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            statement.executeUpdate();
        }
    }
}

