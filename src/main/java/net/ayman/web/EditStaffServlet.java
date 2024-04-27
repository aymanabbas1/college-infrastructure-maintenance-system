package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.StaffDao;
import net.ayman.model.Staff;

import java.io.IOException;

public class EditStaffServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the staff ID from the request parameter
        int staffId = Integer.parseInt(request.getParameter("staffId"));

        // Retrieve the staff details from the database using the StaffDao
        StaffDao staffDao = new StaffDao();
        Staff staffDetails = staffDao.getStaffById(staffId);

        // Set the staff details as an attribute in the request object
        request.setAttribute("staff", staffDetails);

        // Forward the request to the edit staff form page
        request.getRequestDispatcher("edit_staff_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        String staffName = request.getParameter("staffName");
        String contactNoStr = request.getParameter("contactNo");
        long contactNo = Long.parseLong(contactNoStr);

        Staff updatedStaff = new Staff();
        updatedStaff.setStaffId(staffId);
        updatedStaff.setStaffName(staffName);
        updatedStaff.setContactNo(contactNo);

        // Update the staff in the database using the StaffDao
        StaffDao staffDao = new StaffDao();
        boolean success = staffDao.updateStaff(updatedStaff);

        if (success) {
            // If the update was successful, redirect back to the staff page
            request.getRequestDispatcher("/StaffServlet").forward(request, response);
        } else {
            // If the update failed, handle the error (e.g., display an error message)
        	String errorMessage = "Failed to update staff.";
        	request.setAttribute("errorMessage", errorMessage);
        	request.getRequestDispatcher("/StaffServlet").forward(request, response);
        }
    }
}
