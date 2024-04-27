package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ServiceDao;
import net.ayman.model.Service;

import java.io.IOException;


public class AddServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
//    	int serviceId = Integer.valueOf(request.getParameter("serviceId"));
        String serviceName = request.getParameter("serviceName");
        // Add additional parameters as needed

        // Create a new Service object with the provided data
        Service newService = new Service();
        newService.setServiceName(serviceName);
        // Set additional properties as needed

        // Instantiate ServiceDao and call the addService method
        ServiceDao serviceDao = new ServiceDao();
        boolean success = serviceDao.addService(newService);

        if (success) {
            // If service creation is successful, redirect to a success page
            request.getRequestDispatcher("/ServiceServlet").forward(request, response);
        } else {
            // If service creation fails, redirect to an error page or handle it accordingly
        	 String errorMessage = "Failed to add new service. ";
             request.setAttribute("errorMessage", errorMessage);
             request.getRequestDispatcher("/ServiceServlet").forward(request, response);
        }
    }
}
