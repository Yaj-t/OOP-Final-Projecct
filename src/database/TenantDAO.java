package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Tenant;


public class TenantDAO {
    private static Connection conn;

    public TenantDAO() {
 
    }

    // Add a new tenant to the database
    public static void addTenant(Tenant tenant) throws SQLException {
        conn = Connect.connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO tenants (first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)");
        stmt.setString(1, tenant.getFirstName());
        stmt.setString(2, tenant.getLastName());
        stmt.setString(3, tenant.getPhoneNumber());
        stmt.setString(4, tenant.getEmail());
        stmt.executeUpdate();
        Connect.closeConnection();
    }

    // Retrieve a tenant from the database by ID
    public static Tenant getTenantById(int id) throws SQLException {
        conn = Connect.connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tenants WHERE tenant_id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Connect.closeConnection();
            return new Tenant(rs.getInt("tenant_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone_number"), rs.getString("email"));
        }
        Connect.closeConnection();
        return null;
    }

    // Retrieve all tenants from the database
    public static List<Tenant> getAllTenants() throws SQLException {
        conn = Connect.connectToDatabase();
        List<Tenant> tenants = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tenants");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            tenants.add(new Tenant(rs.getInt("tenant_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone_number"), rs.getString("email")));
        }
        Connect.closeConnection();
        return tenants;
        
    }

    // Update a tenant in the database
    public static void updateTenant(Tenant tenant) throws SQLException {
        conn = Connect.connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement("UPDATE tenants SET first_name = ?, last_name = ?, phone_number = ?, email = ? WHERE tenant_id = ?");
        stmt.setString(1, tenant.getFirstName());
        stmt.setString(2, tenant.getLastName());
        stmt.setString(3, tenant.getPhoneNumber());
        stmt.setString(4, tenant.getEmail());
        stmt.setInt(5, tenant.getId());
        stmt.executeUpdate();
        Connect.closeConnection();
    }

    // Delete a tenant from the database by ID
    public static void deleteTenantById(int id) throws SQLException {
        conn = Connect.connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM tenants WHERE tenant_id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        Connect.closeConnection();
    }
}
