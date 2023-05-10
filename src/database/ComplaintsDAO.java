/**

This class represents a data access object for the Complaints table in the database.
It provides methods to retrieve, add, update, and delete Complaint objects.
*/


package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Complaint;

public class ComplaintsDAO {
    /**
     *
     * This class represents a data access object for the Complaints table in
     * the database. It provides methods to retrieve, add, update, and delete
     * Complaint objects.
     */
    public static List<Complaint> getAllComplaints() throws SQLException {
        List<Complaint> complaints = new ArrayList<>();
        try (Connection conn = Connect.connectToDatabase(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM complaints")) {
            while (rs.next()) {
                int id = rs.getInt("complaint_id");
                int roomId = rs.getInt("room_id");
                LocalDate date = rs.getDate("complaint_date").toLocalDate();
                String desc = rs.getString("description");
                Complaint.Status status = Complaint.Status.valueOf(rs.getString("status").toUpperCase());
                Complaint complaint = new Complaint(id, roomId, date, desc, status);
                complaints.add(complaint);
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving all complaints: " + e.getMessage());
        } finally {
            Connect.closeConnection();
        }
        return complaints;
    }
    
    /**
     * Retrieves all unresolved complaints from the Complaints table in the
     * database.
     *
     * @return A list of Complaint objects representing all unresolved
     * complaints in the database.
     * @throws SQLException If there is an error retrieving the complaints from
     * the database.
     */
    public static List<Complaint> getUnresolvedComplaints() throws SQLException {
        List<Complaint> complaints = new ArrayList<>();
        try (Connection conn = Connect.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM complaints WHERE status = ?")) {
            stmt.setString(1, Complaint.Status.UNRESOLVED.name());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("complaint_id");
                int roomId = rs.getInt("room_id");
                LocalDate date = rs.getDate("complaint_date").toLocalDate();
                String desc = rs.getString("description");
                Complaint.Status status = Complaint.Status.valueOf(rs.getString("status").toUpperCase());
                Complaint complaint = new Complaint(id, roomId, date, desc, status);
                complaints.add(complaint);
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving unresolved complaints: " + e.getMessage());
        } finally {
            Connect.closeConnection();
        }
        return complaints;
    }
    
    /**
     * Retrieves a complaint with the given ID from the Complaints table in the
     * database.
     *
     * @param id The ID of the complaint to retrieve.
     * @return A Complaint object representing the complaint with the given ID.
     * @throws SQLException If there is an error retrieving the complaint from
     * the database.
     */
    public static Complaint getComplaintById(int id) throws SQLException {
        Complaint complaint = null;
        try (Connection conn = Connect.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM complaints WHERE complaint_id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int roomId = rs.getInt("room_id");
                LocalDate date = rs.getDate("complaint_date").toLocalDate();
                String desc = rs.getString("description");
                Complaint.Status status = Complaint.Status.valueOf(rs.getString("status").toUpperCase());
                complaint = new Complaint(id, roomId, date, desc, status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            Connect.closeConnection();
        }
        return complaint;
    }
    
    /**
     *
     * Adds a new complaint to the database.
     *
     * @param complaint the Complaint object representing the complaint to add.
     * @return true if the complaint was added successfully, false otherwise.
     * @throws SQLException if an error occurs while accessing the database.
     * @throws IllegalArgumentException if the complaint date is in the future.
     */
    public static boolean addComplaint(Complaint complaint) throws SQLException, IllegalArgumentException {
        boolean success = false;
        LocalDate currentDate = LocalDate.now();
        if (complaint.getDate().isAfter(currentDate)) {
            throw new IllegalArgumentException("Complaint date cannot be in the future");
        }
        try (Connection conn = Connect.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement("INSERT INTO complaints(room_id, complaint_date, description, status) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, complaint.getRoomId());
            stmt.setDate(2, Date.valueOf(complaint.getDate()));
            stmt.setString(3, complaint.getDescription());
            stmt.setString(4, complaint.getStatus().name());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error adding complaint: " + e.getMessage());
        } finally {
            Connect.closeConnection();
        }
        return success;
    }

    /**
     *
     * Updates an existing complaint in the database.
     *
     * @param complaint the Complaint object representing the complaint to
     * update.
     * @return true if the complaint was updated successfully, false otherwise.
     * @throws SQLException if an error occurs while accessing the database.
     * @throws IllegalArgumentException if the complaint date is in the future.
     */
    public static boolean updateComplaint(Complaint complaint) throws SQLException, IllegalArgumentException {
        boolean success = false;
        LocalDate currentDate = LocalDate.now();
        if (complaint.getDate().isAfter(currentDate)) {
            throw new IllegalArgumentException("Complaint date cannot be in the future");
        }
        try (Connection conn = Connect.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement("UPDATE complaints SET room_id = ?, complaint_date = ?, description = ?, status = ? WHERE complaint_id = ?")) {
            stmt.setInt(1, complaint.getRoomId());
            stmt.setDate(2, Date.valueOf(complaint.getDate()));
            stmt.setString(3, complaint.getDescription());
            stmt.setString(4, complaint.getStatus().name());
            stmt.setInt(5, complaint.getComplaintId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error updating complaint: " + e.getMessage());
        } finally {
            Connect.closeConnection();
        }
        return success;
    }

    
    /**
     *
     * Deletes a single complaint from the database with the specified complaint
     * ID.
     *
     * @param complaintId the ID of the complaint to delete.
     * @return true if the complaint was deleted successfully, false otherwise.
     * @throws SQLException if an error occurs while accessing the database.
     */
    public static boolean deleteComplaintById(int complaintId) throws SQLException {
        boolean success = false;
        try (Connection conn = Connect.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM complaints WHERE complaint_id = ?")) {
            stmt.setInt(1, complaintId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            Connect.closeConnection();
        }
        return success;
    }


}
