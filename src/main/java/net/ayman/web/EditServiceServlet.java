package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ServiceDao;
import net.ayman.model.Service;

import java.io.IOException;


public class EditServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditServiceServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the service ID from the request parameter
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        // Retrieve the service details from the database using the ServiceDao
        ServiceDao serviceDao = new ServiceDao();
        Service serviceDetails = serviceDao.getServiceById(serviceId);
        request.setAttribute("service", serviceDetails);

        // Set the service details as an attribute in the request object
       //response.getWriter().println(serviceDetails.getServiceId() + " " + serviceDetails.get)
        // Forward the request to the edit service form page
        request.getRequestDispatcher("edit_service_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        int serviceId = Integer.valueOf(request.getParameter("serviceId"));
        String serviceName = request.getParameter("serviceName");
       

        // Create a Service object with the updated details
        Service updatedService = new Service();
//        updatedService.setServiceId(serviceId);
        updatedService.setServiceName(serviceName);
        updatedService.setServiceId(serviceId);
        // Set additional properties as needed

        // Update the service in the database using the ServiceDao
        ServiceDao serviceDao = new ServiceDao();
        boolean success = serviceDao.updateService(updatedService);

        if (success) {
            // If the update was successful, redirect back to the admin page
        	request.getRequestDispatcher("/ServiceServlet").forward(request, response);
        } else {
            // If the update failed, handle the error (e.g., display an error message)
        	String errorMessage = "Failed to update service. ";
        	request.setAttribute("errorMessage", errorMessage);
        	request.getRequestDispatcher("/ServiceServlet").forward(request, response);

        }
    }
}
