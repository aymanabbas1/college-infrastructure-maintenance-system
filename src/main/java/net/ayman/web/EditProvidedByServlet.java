package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ProvidedByDao;
import net.ayman.model.ProvidedBy;

import java.io.IOException;

public class EditProvidedByServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the staff ID and service ID from the request parameters
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        // Retrieve the providedBy details from the database using the ProvidedByDao
        ProvidedByDao providedByDao = new ProvidedByDao();
        ProvidedBy providedByDetails = providedByDao.getProvidedByById(staffId, serviceId);

        // Set the providedBy details as an attribute in the request object
        request.setAttribute("providedBy", providedByDetails);

        // Forward the request to the edit providedBy form page
        request.getRequestDispatcher("edit_providedby_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from request parameters
        int oldStaffId = Integer.parseInt(request.getParameter("oldStaffId"));
        int oldServiceId = Integer.parseInt(request.getParameter("oldServiceId"));
        int newStaffId = Integer.parseInt(request.getParameter("newStaffId"));
        int newServiceId = Integer.parseInt(request.getParameter("newServiceId"));
        // Add more parameters as needed

        // Create a new ProvidedBy object with the provided data
        ProvidedBy updatedProvidedBy = new ProvidedBy();
        updatedProvidedBy.setStaffId(oldStaffId); // Set old staffId
        updatedProvidedBy.setServiceId(oldServiceId); // Set old serviceId
        // Set new values
        updatedProvidedBy.setNewStaffId(newStaffId);
        updatedProvidedBy.setNewServiceId(newServiceId);
        // Set other properties

        // Update the providedBy in the database using the ProvidedByDao
        ProvidedByDao providedByDao = new ProvidedByDao();
        boolean success = providedByDao.updateProvidedBy(updatedProvidedBy);

        if (success) {
            // If the update was successful, redirect back to the providedBy list page
            request.getRequestDispatcher("/ProvidedByServlet").forward(request, response);
        } else {
            // If the update failed, handle the error (e.g., display an error message)
        	String errorMessage = "Failed to update Service-Staff Assignment. ";
        	request.setAttribute("errorMessage", errorMessage);  
        	request.getRequestDispatcher("/ProvidedByServlet").forward(request, response);
}
    } 

}
