package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.StaffDao;
import net.ayman.model.Staff;

import java.io.IOException;


public class AddStaffServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String staffName = request.getParameter("staffName");
        String contactNoStr = request.getParameter("contactNo");
        long contactNo = Long.parseLong(contactNoStr);

        // Create a new Staff object with the provided data
        Staff newStaff = new Staff();
        newStaff.setStaffName(staffName);
        newStaff.setContactNo(contactNo);

        // Instantiate StaffDao and call the addStaff method
        StaffDao staffDao = new StaffDao();
        boolean success = staffDao.addStaff(newStaff);

        if (success) {
            // If staff addition is successful, redirect to a success page or the staff list page
        	request.getRequestDispatcher("/StaffServlet").forward(request, response);
        } else {
            // If staff addition fails, redirect to an error page
        	  String errorMessage = "Failed to add new staff. ";
        	  
          	request.setAttribute("errorMessage", errorMessage);
        	request.getRequestDispatcher("/StaffServlet").forward(request, response);

          	
        }
    }
}
