package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.RequestDao;
import net.ayman.dao.ServiceDao;
import net.ayman.dao.UserDao;
import net.ayman.model.Request;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
    	String username = "admin";

        // Retrieve the user ID associated with the username from the database
        UserDao userDao = new UserDao();
        int userId = userDao.getUserIdByUsername(username);
        String serviceName = request.getParameter("serviceName");

        // Retrieve the service ID associated with the service name from the database
        ServiceDao serviceDao = new ServiceDao();
        int serviceId = serviceDao.getServiceIdByServiceName(serviceName);

        String location = request.getParameter("location");
        String staffIdString = request.getParameter("staffId");
      
        if (isDuplicateRequest(serviceId, location)) {
            // If a similar request exists, redirect to a page indicating that the request is a duplicate
        	String errorMessage = "Failed to add new request. The request already exists.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/Request0Servlet").forward(request, response);
            
        }
        
        else {
        // Create a new Request object with the provided data
        Request newRequest = new Request();
        newRequest.setUserId(userId);
        newRequest.setServiceId(serviceId);
        newRequest.setLocation(location);
      

        // Instantiate RequestDao and call the addRequest method
        RequestDao requestDao = new RequestDao();
        boolean success = requestDao.addRequest(newRequest);

        if (success) {
            // If request creation is successful, redirect to a success page
        	request.getRequestDispatcher("request0.jsp").forward(request, response);
        } else {
        	String errorMessage = "Failed to add new request. ";
      	  
          	request.setAttribute("errorMessage", errorMessage);
        	request.getRequestDispatcher("request0.jsp").forward(request, response);

          
        }
    }
    }
    
    private boolean isDuplicateRequest(int serviceId, String location) {
        // Define SQL query to check for duplicate requests
        String sql = "SELECT COUNT(*) FROM request WHERE service_id = ? AND location = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set parameters in the PreparedStatement
            statement.setInt(1, serviceId);
            statement.setString(2, location);

            // Execute the query
            try (ResultSet resultSet = statement.executeQuery()) {
                // If any rows are returned, it means a duplicate request exists
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);// if its null will return 0, as int is initialized to 0 in java.
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions appropriately
        }

        return false; // Return false if an exception occurs or no duplicate request is found
    }
    
    private Connection getConnection() throws SQLException {
    	
    	  final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    	      final String USERNAME = "root";
    	      final String PASSWORD = "0000";
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect(request.getContextPath() + "/newrequestform.jsp");
    }
}
