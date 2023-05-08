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
    public static int addTenant(Tenant tenant) throws SQLException {
        conn = Connect.connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO tenant (first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, tenant.getFirstName());
        stmt.setString(2, tenant.getLastName());
        stmt.setString(3, tenant.getPhoneNumber());
        stmt.setString(4, tenant.getEmail());
        stmt.executeUpdate();
    
        int tenantID = 0;
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            tenantID = generatedKeys.getInt(1);
        }
    
        Connect.closeConnection();
        return tenantID;
    }
    

    // Retrieve a tenant from the database by ID
    public static Tenant getTenantById(int id) throws SQLException {
        
        conn = Connect.connectToDatabase();
        Tenant tenant = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tenant WHERE tenant_id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
             tenant = new Tenant(rs.getInt("tenant_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone_number"), rs.getString("email"));
        }
        Connect.closeConnection();
        return tenant;
    }

    // Retrieve all tenant from the database
    public static List<Tenant> getAlltenant() throws SQLException {
        conn = Connect.connectToDatabase();
        List<Tenant> tenant = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tenant");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            tenant.add(new Tenant(rs.getInt("tenant_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone_number"), rs.getString("email")));
        }
        Connect.closeConnection();
        return tenant;
        
    }

    // Update a tenant in the database
    public static void updateTenant(Tenant tenant) throws SQLException {
        conn = Connect.connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement("UPDATE tenant SET first_name = ?, last_name = ?, phone_number = ?, email = ? WHERE tenant_id = ?");
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
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM tenant WHERE tenant_id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        Connect.closeConnection();
    }
}
