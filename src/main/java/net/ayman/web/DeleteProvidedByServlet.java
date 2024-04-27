package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ProvidedByDao;

import java.io.IOException;


public class DeleteProvidedByServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the staff ID and service ID to be deleted from the request parameters
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        // Create an instance of ProvidedByDao to perform database operations
        ProvidedByDao providedByDao = new ProvidedByDao();

        // Attempt to delete the providedBy entry from the database
        boolean success = providedByDao.deleteProvidedBy(staffId, serviceId);

        // Check if the deletion was successful
        if (success) {
            // If successful, redirect to a success page or another appropriate location
            response.sendRedirect(request.getContextPath() + "/ProvidedByServlet");
        } else {
            // If deletion failed, handle the error accordingly
            response.getWriter().println("Failed to delete providedBy.");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the doGet() method
        doGet(request, response);
    }
}
