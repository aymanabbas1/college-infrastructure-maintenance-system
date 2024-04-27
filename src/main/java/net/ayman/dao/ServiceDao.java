package net.ayman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ayman.model.Service;

public class ServiceDao {

    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";
	
	
    public boolean deleteService(int serviceId) {
        String sql = "DELETE FROM service WHERE service_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, serviceId);
            int rowsAffected = statement.executeUpdate();
            // If deletion was successful (1 row affected), return true
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }
	
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM service"; 
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                	Service service = new Service();
                     service.setServiceId(resultSet.getInt("service_id"));
                     service.setServiceName(resultSet.getString("service_name"));
                    
                    // Create a User object with the retrieved data
                    
                    services.add(service);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here
        }

        return services;
    }
    
    public Service getServiceById(int serviceId) {
        Service service = null;
        String sql = "SELECT * FROM service WHERE service_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, serviceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // If a service with the given serviceId is found, create a Service object
                    service = new Service();
                    service.setServiceId(resultSet.getInt("service_id"));
                    service.setServiceName(resultSet.getString("service_name"));
                    return service;
                    // Optionally set other attributes like servicePrice, serviceDescription, etc.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging or throwing it
        }
        return service;
    }
    
    public boolean updateService(Service updatedService) {
        // SQL query to update a service in the database
        String sql = "UPDATE service SET service_name = ? WHERE service_id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters in the PreparedStatement
            statement.setString(1, updatedService.getServiceName());
            statement.setInt(2, updatedService.getServiceId());
            
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
    public boolean addService(Service service) {
        String sql = "INSERT INTO service (service_name) VALUES (?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, service.getServiceName());
            int rowsAffected = statement.executeUpdate();

            // If one row is affected, insertion is successful
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getServiceIdByServiceName(String serviceName) {
        int serviceId = -1;
        try (Connection connection = getConnection()) {
            String sql = "SELECT service_id FROM service WHERE service_name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, serviceName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        serviceId = resultSet.getInt("service_id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceId;
    }

    public String getServiceNameById(int serviceId) {
       String serviceName = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT service_name FROM service WHERE service_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, serviceId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        serviceName = resultSet.getString("service_name");
                        return serviceName;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceName;
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
