/**
 *
 * This class provides data access to the rooms table in the database. It allows to perform
 * CRUD operations on the rooms table, including adding, updating and deleting rooms.
 */
package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Room;

public class RoomDAO {

    private static Connection connection;
    
    /**
     * Constructor to create a new RoomDAO object. If the connection to the
     * database is null, it tries to connect to the database by calling the
     * connectToDatabase() method of the Connect class.
     */
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
    
        /**
     * Inserts a new room into the rooms table.
     *
     * @param room a Room object containing the room_number, room_price, and
     * description of the new room.
     * @throws SQLException
     */

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
    
    /**
     * Returns a list of all rooms in the rooms table.
     *
     * @return a List of Room objects containing all the rooms in the rooms
     * table.
     * @throws SQLException
     */
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

    /**
     * Returns a list of all available rooms for a given date range.
     *
     * @param startDate the start date of the date range.
     * @param endDate the end date of the date range.
     * @return a List of Room objects containing all the available rooms for the
     * given date range.
     * @throws SQLException
     */
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
    
    /**
     *
     * Returns a Room object with the given room ID.
     *
     * @param id The ID of the room to be retrieved
     * @return A Room object with the given ID, or null if no room with the
     * given ID exists
     * @throws SQLException if there is an error executing the SQL query
     */
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

    /**
     *
     * Returns a Room object with the given room number.
     *
     * @param roomNumber The room number of the room to be retrieved
     * @return A Room object with the given room number, or null if no room with
     * the given room number exists
     * @throws SQLException if there is an error executing the SQL query
     */
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

    /**
     *
     * Updates the information of a room in the database.
     *
     * @param room The Room object to be updated
     * @throws SQLException if there is an error executing the SQL query
     */
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

    /**
     *
     * Deletes a room from the database with the given room number.
     *
     * @param roomNumber The room number of the room to be deleted
     * @throws SQLException if there is an error executing the SQL query
     */
    public static void deleteRoom(String roomNumber) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM rooms WHERE room_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomNumber);
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }
    
    /**
     *
     * Deletes a room from the database with the given room ID.
     *
     * @param roomID The ID of the room to be deleted
     * @throws SQLException if there is an error executing the SQL query
     */
    public static void deleteRoombyID(int roomID) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "DELETE FROM rooms WHERE room_id = ?";

        

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomID);
            statement.executeUpdate();
        }
        Connect.closeConnection();
    }

    /**
     *
     * Checks whether a room has been rented and if the rental is still active.
     *
     * @param roomID The ID of the room to be checked
     * @return true if the room has been rented and the rental is still active,
     * false otherwise
     * @throws SQLException if there is an error executing the SQL query
     */
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

    /**
     *
     * Checks whether a room with the given room number already exists in the
     * database.
     *
     * @param roomNumber The room number to be checked
     * @return true if a room with the given room number exists, false otherwise
     * @throws SQLException if there is an error executing the SQL query
     */
    public static boolean isRoomNumberUsed(String roomNumber) throws SQLException {
        connection = Connect.connectToDatabase();
        String sql = "SELECT * FROM rooms WHERE room_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomNumber);
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
