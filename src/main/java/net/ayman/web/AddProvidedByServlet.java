package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ProvidedByDao;
import net.ayman.model.ProvidedBy;

import java.io.IOException;

public class AddProvidedByServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        // Add more parameters as needed

        // Create a new ProvidedBy object with the provided data
        ProvidedBy newProvidedBy = new ProvidedBy();
        newProvidedBy.setStaffId(staffId);
        newProvidedBy.setServiceId(serviceId);
        // Set other properties

        // Instantiate ProvidedByDao and call the addProvidedBy method
        ProvidedByDao providedByDao = new ProvidedByDao();
        boolean success = providedByDao.addProvidedBy(newProvidedBy);

        if (success) {
            // If ProvidedBy creation is successful, redirect to a success page
        	request.getRequestDispatcher("/ProvidedByServlet").forward(request, response);
        } else {
            // If ProvidedBy creation fails, redirect to an error page
        	String errorMessage = "Failed to add new Service-Staff Assignment. ";
        	request.setAttribute("errorMessage", errorMessage);  
        	request.getRequestDispatcher("/ProvidedByServlet").forward(request, response);
        }
    }
}
