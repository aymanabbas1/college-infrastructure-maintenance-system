package net.ayman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ayman.model.Request;
import net.ayman.model.RequestView;

public class RequestViewDao {

	private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";
	
	
	
	 public List<RequestView> getAllCompletionAndStaffRequestsView() {
	        List<RequestView> requests = new ArrayList<>();
	        String sql = "SELECT * FROM request WHERE status = 'PENDING' AND staff_id is NULL AND date_of_completion is NULL"; // Ordering by status in descending order
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                // Create Request objects and add them to the list
	                RequestView request = new RequestView();
	                request.setRequestId(resultSet.getInt("request_id"));
	                request.setUserId(resultSet.getInt("user_id")); 
	                request.setDateOfRequest(resultSet.getDate("date_of_request"));
	                request.setLocation(resultSet.getString("location"));
	                request.setStatus(resultSet.getString("status"));
	                request.setDateOfCompletion(resultSet.getDate("date_of_completion"));
	                Integer intermediateStaffId = resultSet.getInt("staff_id");
	                if (resultSet.wasNull()) {
	                    request.setStaffId(null);
	                } else {
	                    request.setStaffId(intermediateStaffId);
	                }
	                int serviceId = resultSet.getInt("service_id");
	                ServiceDao dao = new ServiceDao();
	                String serviceName = dao.getServiceNameById(serviceId);
	                request.setServiceName(serviceName);
	                
	                // Add additional columns as needed
	                requests.add(request);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the exception appropriately, e.g., logging or throwing it
	        }
	        return requests;
	    }
	 
	 public RequestView getRequestViewById(int requestId) {
		    RequestView request = null;
		    String sql = "SELECT * FROM request WHERE request_id = ?";
		    try (Connection connection = getConnection();
		         PreparedStatement statement = connection.prepareStatement(sql)) {
		        // Set the request ID as a parameter in the SQL query
		        statement.setInt(1, requestId);
		        try (ResultSet resultSet = statement.executeQuery()) {
		            if (resultSet.next()) {
		                // Create a RequestView object and set its attributes
		                request = new RequestView();
		                request.setRequestId(resultSet.getInt("request_id"));
		                request.setUserId(resultSet.getInt("user_id"));
		                request.setDateOfRequest(resultSet.getDate("date_of_request"));
		                request.setLocation(resultSet.getString("location"));
		                request.setStatus(resultSet.getString("status"));
		                request.setDateOfCompletion(resultSet.getDate("date_of_completion"));
		                Integer intermediateStaffId = resultSet.getInt("staff_id");
		                if (resultSet.wasNull()) {
		                    request.setStaffId(null);
		                } else {
		                    request.setStaffId(intermediateStaffId);
		                }
		                int serviceId = resultSet.getInt("service_id");
		                ServiceDao dao = new ServiceDao();
		                String serviceName = dao.getServiceNameById(serviceId);
		                request.setServiceName(serviceName);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Handle the exception appropriately, e.g., logging or throwing it
		    }
		    return request;
		}
	 
	 
	 public List<RequestView> getAllCompletionRequestsView() {
	        List<RequestView> requests = new ArrayList<>();
	        String sql = "SELECT * FROM request WHERE status = 'PENDING' AND staff_id is not NULL AND date_of_completion is NULL"; // Ordering by status in descending order
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                // Create Request objects and add them to the list
	                RequestView request = new RequestView();
	                request.setRequestId(resultSet.getInt("request_id"));
	                request.setUserId(resultSet.getInt("user_id")); 
	                request.setDateOfRequest(resultSet.getDate("date_of_request"));
	                request.setLocation(resultSet.getString("location"));
	                request.setStatus(resultSet.getString("status"));
	                request.setDateOfCompletion(resultSet.getDate("date_of_completion"));
	                request.setStaffId(resultSet.getInt("staff_id"));
	                int serviceId = resultSet.getInt("service_id");
	                ServiceDao dao = new ServiceDao();
	                String serviceName = dao.getServiceNameById(serviceId);
	                request.setServiceName(serviceName);
	                
	                // Add additional columns as needed
	                requests.add(request);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the exception appropriately, e.g., logging or throwing it
	        }
	        return requests;
	    }
	 
	 public List<RequestView> getAllHistoryRequestsView() {
	        List<RequestView> requests = new ArrayList<>();
	        String sql = "SELECT * FROM request WHERE status = 'COMPLETED' AND staff_id is not NULL AND date_of_completion is not NULL"; // Ordering by status in descending order
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                // Create Request objects and add them to the list
	                RequestView request = new RequestView();
	                request.setRequestId(resultSet.getInt("request_id"));
	                request.setUserId(resultSet.getInt("user_id")); 
	                request.setDateOfRequest(resultSet.getDate("date_of_request"));
	                request.setLocation(resultSet.getString("location"));
	                request.setStatus(resultSet.getString("status"));
	                request.setDateOfCompletion(resultSet.getDate("date_of_completion"));
	                request.setStaffId(resultSet.getInt("staff_id"));
	                int serviceId = resultSet.getInt("service_id");
	                ServiceDao dao = new ServiceDao();
	                String serviceName = dao.getServiceNameById(serviceId);
	                request.setServiceName(serviceName);
	                
	                // Add additional columns as needed
	                requests.add(request);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the exception appropriately, e.g., logging or throwing it
	        }
	        return requests;
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
