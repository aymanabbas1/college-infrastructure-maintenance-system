 package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ServiceDao;
import net.ayman.dao.UserDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;


public class UserFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";

    public UserFormServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 

         // Construct the location based on the information received
         String location = request.getParameter("location");
         String area = request.getParameter("area");
         String floor = "floor " + request.getParameter("floor");
         String classroomNumber = request.getParameter("classroomNumber");
         String username = request.getParameter("username");
         String serviceName = request.getParameter("service");
         
         if ("Classroom".equals(area)) {
             // If the area is a classroom, append the classroom number to the location
             location += " " + area + " " + floor + " " + classroomNumber;
         } else {
             // Otherwise, append only the area and floor to the location
             location += " " + area + " "  + floor;
         }
         UserDao userDao = new UserDao();
         ServiceDao serviceDao = new ServiceDao();
        int userId = userDao.getUserIdByUsername(username);
        int serviceId = serviceDao.getServiceIdByServiceName(serviceName);
        
//     // Get the current date
//        LocalDate currentDate = LocalDate.now();
//
//        // Convert LocalDate to java.sql.Date
//        Date sqlDate = Date.valueOf(currentDate);

        if (isDuplicateRequest(serviceId, location)) {
            // If a similar request exists, redirect to a page indicating that the request is a duplicate
            request.getRequestDispatcher("duplicaterequest.jsp").forward(request, response);
            
        }
        else {
        	
        
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO request (service_id, user_id, location) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, serviceId);
                statement.setInt(2, userId);
                statement.setString(3, location);
               
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        }
    }
    
    private boolean isDuplicateRequest(int serviceId, String location) {
        // Define SQL query to check for duplicate requests
        String sql = "SELECT COUNT(*) FROM request WHERE service_id = ? AND location = ? AND status = 'PENDING'";

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
