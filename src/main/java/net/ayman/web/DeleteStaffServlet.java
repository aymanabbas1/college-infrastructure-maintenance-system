package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.StaffDao;

import java.io.IOException;


public class DeleteStaffServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the staff ID to be deleted from the request parameter
        int staffId = Integer.parseInt(request.getParameter("staffId"));

        // Create an instance of StaffDao to perform database operations
        StaffDao staffDao = new StaffDao();

        // Attempt to delete the staff member from the database
        boolean success = staffDao.deleteStaff(staffId);

        // Check if the deletion was successful
        if (success) {
            // If successful, redirect the user to a success page or another appropriate location
            request.getRequestDispatcher("/StaffServlet").forward(request, response);
        } else {
            // If deletion failed, handle the error accordingly
            response.getWriter().println("Failed to delete staff member.");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the doGet() method
        doGet(request, response);
    }
}
