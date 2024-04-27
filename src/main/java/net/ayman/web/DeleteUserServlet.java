package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.UserDao;

import java.io.IOException;


public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the user ID to be deleted from the request parameter
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Create an instance of UserDao to perform database operations
        UserDao userDao = new UserDao();

        // Attempt to delete the user from the database
        boolean success = userDao.deleteUser(userId);

        // Check if the deletion was successful
        if (success) {
            // If successful, redirect the user to a success page or another appropriate location
        	request.getRequestDispatcher("/UserServlet").forward(request, response);
        } else {
            // If deletion failed, handle the error accordingly
        	response.getWriter().println("Failed to delete user.");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the doPost() method
        doGet(request, response);
    }
}
