package net.ayman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ayman.model.Staff;

public class StaffDao {

    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";

    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM staff";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Staff staff = new Staff();
                    staff.setStaffId(resultSet.getInt("staff_id"));
                    staff.setStaffName(resultSet.getString("staff_name"));
                    staff.setContactNo(resultSet.getLong("contact_no"));
                    // Set other properties if necessary
                    
                    staffList.add(staff);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here
        }

        return staffList;
    }

    // Add other methods as needed, such as addStaff, deleteStaff, updateStaff, etc.
    
    
    public boolean updateStaff(Staff updatedStaff) {
        String sql = "UPDATE staff SET staff_name = ?, contact_no = ? WHERE staff_id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters in the PreparedStatement
            statement.setString(1, updatedStaff.getStaffName());
            statement.setLong(2, updatedStaff.getContactNo());
            statement.setInt(3, updatedStaff.getStaffId());
            
            // Execute the update query
            int rowsAffected = statement.executeUpdate();
             
            // If update was successful (1 row affected), return true
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }
    
    public Staff getStaffById(int staffId) {
        Staff staff = null;
        String sql = "SELECT * FROM staff WHERE staff_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staffId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    staff = new Staff();
                    staff.setStaffId(resultSet.getInt("staff_id"));
                    staff.setStaffName(resultSet.getString("staff_name"));
                    staff.setContactNo(resultSet.getLong("contact_no"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }
    
    
    public boolean addStaff(Staff staff) {
        String sql = "INSERT INTO staff (staff_name, contact_no) VALUES (?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getStaffName());
            statement.setLong(2, staff.getContactNo());
            
            int rowsAffected = statement.executeUpdate();
            
            // If one row is affected, insertion is successful
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaff(int staffId) {
        String sql = "DELETE FROM staff WHERE staff_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staffId);
            int rowsAffected = statement.executeUpdate();
            // If deletion was successful (1 row affected), return true
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }

    
    

    private Connection getConnection() throws SQLException {
        try {
            // Attempt to load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // If the driver class is not found, print an error message
            System.err.println("MySQL JDBC Driver not found. Make sure it's included in your classpath.");
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
