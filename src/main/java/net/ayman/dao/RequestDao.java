package net.ayman.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ayman.model.Request;
 

public class RequestDao {
    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM request ORDER BY status DESC"; // Ordering by status in descending order
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Create Request objects and add them to the list
                Request request = new Request();
                request.setRequestId(resultSet.getInt("request_id"));
                request.setUserId(resultSet.getInt("user_id"));
                request.setServiceId(resultSet.getInt("service_id"));
                request.setDateOfRequest(resultSet.getDate("date_of_request"));
                request.setLocation(resultSet.getString("location"));
                request.setStatus(resultSet.getString("status"));
                // Add additional columns as needed
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging or throwing it
        }
        return requests;
    }
    
    
    public boolean addRequest(Request request) {
        String sql = "INSERT INTO request (user_id, service_id, location) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters in the PreparedStatement
            statement.setInt(1, request.getUserId());
            statement.setInt(2, request.getServiceId());
            statement.setString(3, request.getLocation());
         

            // Execute the update query
            int rowsAffected = statement.executeUpdate();

            // If one row is affected, insertion is successful
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteRequest(int requestId) {
        // SQL query to delete a request by its ID
        String sql = "DELETE FROM request WHERE request_id = ?";
        
        // Try-with-resources to automatically close the resources (Connection and PreparedStatement)
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the request ID parameter in the PreparedStatement
            statement.setInt(1, requestId);
            
            // Execute the delete query
            int rowsAffected = statement.executeUpdate();
                    // If deletion was successful (1 row affected), return true
             
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }
    
    public Request getRequestById(int requestId) {
        Request request = null;
        String sql = "SELECT * FROM request WHERE request_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, requestId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Create a new Request object and set its properties
                    request = new Request();
                    request.setRequestId(resultSet.getInt("request_id"));
                    request.setUserId(resultSet.getInt("user_id"));
                    request.setServiceId(resultSet.getInt("service_id"));
                    request.setDateOfRequest(resultSet.getDate("date_of_request"));
                    request.setLocation(resultSet.getString("location"));
                    request.setStatus(resultSet.getString("status"));
                    // Add additional properties as needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging or throwing it
        }
        return request;
    }
    
    
    public boolean updateRequest(Request updatedRequest) {
        // SQL query to update a request in the database
        String sql = "UPDATE request SET staff_id = ?, status = ? WHERE request_id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters in the PreparedStatement
            statement.setInt(1, updatedRequest.getStaffId());
            statement.setString(2, updatedRequest.getStatus());
            statement.setInt(3, updatedRequest.getRequestId());
            
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

    
   

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Make sure it's included in your classpath.");
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}