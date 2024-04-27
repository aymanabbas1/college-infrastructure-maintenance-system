package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.RequestDao;
import net.ayman.dao.UserDao;
import net.ayman.model.Request;
import net.ayman.model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditUserServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the request ID from the request parameter
	        int userId = Integer.parseInt(request.getParameter("userId"));
	        
	        // Retrieve the request details from the database using the RequestDao
	        UserDao userDao = new UserDao();
	        User userDetails = userDao.getUserById(userId);

	        // Set the request details as an attribute in the request object
	        request.setAttribute("user", userDetails);

	        // Forward the request to the edit request form page
	        request.getRequestDispatcher("edit_user_form.jsp").forward(request, response);
	    }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	int userId = Integer.parseInt(request.getParameter("userId"));
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	      
	      
	        
	        User updatedUser = new User();
	        updatedUser.setUsername(username);
	        updatedUser.setPassword(password);
	        updatedUser.setUserId(userId);
	      
	        
	        // Update the request in the database using the RequestDao
	        UserDao userDao = new UserDao();
	        boolean success = userDao.updateUser(updatedUser);
	        
	        if (success) {
	            // If the update was successful, redirect back to the admin page
	        	request.getRequestDispatcher("/UserServlet").forward(request, response);
	        } else {
	            // If the update failed, handle the error (e.g., display an error message)
	        	String errorMessage = "Failed to update user.";
	        	request.setAttribute("errorMessage", errorMessage);
	        	request.getRequestDispatcher("/UserServlet").forward(request, response);
	        }
	    
	 }
	 
}

