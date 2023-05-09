/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author Predator
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Room;

public class RoomDAO {

    private static Connection connection;

    public RoomDAO() {
        if (Connect.connection == null) {
            try {
                Connect.connectToDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Connect.closeConnection();
    }

    public static void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (room_number, room_price, description) VALUES (?, ?, ?)";
        connection = Connect.connectToDatabase();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, room.getRoomNumber());
            statement.setDouble(2, room.getPrice());
            statement.setString(3, room.getDescription());
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    public static List<Room> getAllRooms() throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rooms";
        List<Room> rooms = new ArrayList<>();

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int roomID = resultSet.getInt("room_id");
                String roomNumber = resultSet.getString("room_number");
                double price = resultSet.getFloat("room_price");
                String description = resultSet.getString("description");
                Room room = new Room(roomID, roomNumber, price, description);

                rooms.add(room);
            }
        }
        Connect.closeConnection();
        return rooms;
    }

    public static List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate) throws SQLException {
        List<Room> availableRooms = new ArrayList<>();
        connection = Connect.connectToDatabase();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT room_id, room_number, description, room_price FROM rooms "
                + "WHERE room_id NOT IN ("
                + "SELECT room_id FROM rentals "
                + "WHERE (check_in_date <= ? AND check_out_date >= ?) "
                + "   OR (check_in_date <= ? AND check_out_date >= ?) "
                + "   OR (check_in_date >= ? AND check_out_date <= ?)"
                + ")"
        )) {
            statement.setDate(1, java.sql.Date.valueOf(startDate));
            statement.setDate(2, java.sql.Date.valueOf(startDate));
            statement.setDate(3, java.sql.Date.valueOf(endDate));
            statement.setDate(4, java.sql.Date.valueOf(endDate));
            statement.setDate(5, java.sql.Date.valueOf(startDate));
            statement.setDate(6, java.sql.Date.valueOf(endDate));

            boolean check = false;
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Room room = new Room();
                    room.setId(resultSet.getInt("room_id"));
                    room.setRoomNumber(resultSet.getString("room_number"));
                    room.setDescription(resultSet.getString("description"));
                    room.setPrice(resultSet.getDouble("room_price"));
                    availableRooms.add(room);
                    check = true;
                }
            }

            if (!check) {
                System.out.println("No rooms available for the selected dates.");
            }
        }
        Connect.closeConnection();
        return availableRooms;
    }

    public static Room getRoomByID(int id) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        Room room = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int roomID = id;
                    String roomNumber = resultSet.getString("room_number");
                    Double price = resultSet.getDouble("room_price");
                    String description = resultSet.getString("description");

                    room = new Room(roomID, roomNumber, price, description);
                }
            }
        }
        Connect.closeConnection();
        return room;
    }

    public static Room getRoomByNumber(String roomNumber) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rooms WHERE room_number = ?";
        Room room = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int roomID = resultSet.getInt("room_id");
                    roomNumber = resultSet.getString("room_number");
                    int price = resultSet.getInt("room_price");
                    String description = resultSet.getString("description");

                    room = new Room(roomID, roomNumber, price, description);
                }
            }
        }
        Connect.closeConnection();
        return room;
    }

    public static void updateRoom(Room room) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "UPDATE rooms SET room_price = ?, description = ? WHERE room_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, room.getPrice());
            statement.setString(2, room.getDescription());
            statement.setString(3, room.getRoomNumber());

            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    public static void deleteRoom(String roomNumber) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM rooms WHERE room_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomNumber);
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    public static void deleteRoombyID(int roomID) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM rooms WHERE room_id = ?";

        

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    // Check if room has been rented and if the rental is still active
    public static boolean isRoomRented(int roomID) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rentals WHERE room_id = ? AND check_out_date > ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
            }
        } finally {
            Connect.closeConnection();
        }
        return false;
    }

}
