package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.RequestDao;
import net.ayman.dao.RequestViewDao;
import net.ayman.dao.ServiceDao;
import net.ayman.model.Request;
import net.ayman.model.RequestView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Servlet implementation class EditRequestServlet
 */
public class EditRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the request ID from the request parameter
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        
        // Retrieve the request details from the database using the RequestDao
        RequestViewDao dao = new RequestViewDao();
        RequestView requestDetails = dao.getRequestViewById(requestId);
        
        
        // Set the request details as an attribute in the request object
        request.setAttribute("request", requestDetails);
        String bothVisible = request.getParameter("bothVisible");
        if (bothVisible != null && bothVisible.equals("0")) {
            // Forward the request to edit_request_form2.jsp if bothVisible is 0
            request.getRequestDispatcher("edit_request_form2.jsp").forward(request, response);
        } else {
            // Forward the request to edit_request_form1.jsp otherwise
            request.getRequestDispatcher("edit_request_form.jsp").forward(request, response);
        }}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Retrieve parameters from the request
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String serviceName = request.getParameter("serviceName");
        int userId = Integer.parseInt(request.getParameter("userId"));
        String location = request.getParameter("location");
        String status = request.getParameter("status");
        String date1String = request.getParameter("dateOfRequest");

        Integer staffId = Integer.parseInt(request.getParameter("staffId"));
        ServiceDao dao = new ServiceDao();
        int serviceId = dao.getServiceIdByServiceName(serviceName);
      

     // Parse the string into a LocalDate object using DateTimeFormatter
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     LocalDate localDate1 = LocalDate.parse(date1String, formatter);

     
     
     java.sql.Date sqlDate1 = java.sql.Date.valueOf(localDate1);

        // Create a Request object with the updated details
        Request updatedRequest = new Request();
        updatedRequest.setRequestId(requestId);
        updatedRequest.setUserId(userId);
        updatedRequest.setLocation(location);
        updatedRequest.setStatus(status);
        updatedRequest.setServiceId(serviceId);
        updatedRequest.setDateOfRequest(sqlDate1);

        updatedRequest.setStaffId(staffId);
        
        // Set additional properties as needed
        
        // Update the request in the database using the RequestDao
        RequestDao requestDao = new RequestDao();
        boolean success = requestDao.updateRequest(updatedRequest);
        
        if (success) {
            // If the update was successful, redirect back to the admin page
        	request.getRequestDispatcher("admin0.jsp").forward(request, response);
        } else {
        	String errorMessage = "Failed to edit request. ";
      	  
          	request.setAttribute("errorMessage", errorMessage);
        	request.getRequestDispatcher("request0.jsp").forward(request, response);

        }
    
	}

}
