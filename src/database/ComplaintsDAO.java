/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Complaint;

public class ComplaintsDAO {

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
