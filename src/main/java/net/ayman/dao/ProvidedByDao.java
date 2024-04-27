package net.ayman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ayman.model.ProvidedBy;

public class ProvidedByDao {

    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";

    public List<ProvidedBy> getAllProvidedBy() {
        List<ProvidedBy> providedByList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM providedby";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ProvidedBy providedBy = new ProvidedBy();
                    providedBy.setStaffId(resultSet.getInt("staff_id"));
                    providedBy.setServiceId(resultSet.getInt("service_id"));
                    // Create a ProvidedBy object with the retrieved data
                    providedByList.add(providedBy);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here
        }

        return providedByList;
    }

    
    public ProvidedBy getProvidedByById(int staffId, int serviceId) {
        ProvidedBy providedBy = null;
        String sql = "SELECT * FROM providedby WHERE staff_id = ? AND service_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staffId);
            statement.setInt(2, serviceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // If a providedBy with the given staff ID and service ID is found, create a ProvidedBy object
                    providedBy = new ProvidedBy();
                    providedBy.setStaffId(resultSet.getInt("staff_id"));
                    providedBy.setServiceId(resultSet.getInt("service_id"));
                    // Set other properties as needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging or throwing it
        }
        return providedBy;
    }
    
  
        public boolean updateProvidedBy(ProvidedBy updatedProvidedBy) {
            String sql = "UPDATE providedby SET staff_id = ?, service_id = ? WHERE staff_id = ? AND service_id = ?";
            
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set the parameters in the PreparedStatement
                statement.setInt(1, updatedProvidedBy.getNewStaffId());
                statement.setInt(2, updatedProvidedBy.getNewServiceId());
                statement.setInt(3, updatedProvidedBy.getStaffId()); // Old staffId
                statement.setInt(4, updatedProvidedBy.getServiceId()); // Old serviceId
                
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
        
        public boolean addProvidedBy(ProvidedBy providedBy) {
            String sql = "INSERT INTO providedby (staff_id, service_id) VALUES (?, ?)";

            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, providedBy.getStaffId());
                statement.setInt(2, providedBy.getServiceId());

                int rowsAffected = statement.executeUpdate();

                // If one row is affected, insertion is successful
                return rowsAffected == 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean deleteProvidedBy(int staffId, int serviceId) {
            String sql = "DELETE FROM providedby WHERE staff_id = ? AND service_id = ?";
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, staffId);
                statement.setInt(2, serviceId);
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
