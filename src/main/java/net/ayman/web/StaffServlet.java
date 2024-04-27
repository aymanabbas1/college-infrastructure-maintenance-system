package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.StaffDao;
import net.ayman.model.Staff;

import java.io.IOException;
import java.util.List;

public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StaffServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StaffDao staffDao = new StaffDao();
        List<Staff> staffList = staffDao.getAllStaff(); // Assuming staffDao is already initialized
        

//        // Loop through the staff list and print each staff member's details
//        for (Staff staff : staffList) {
//            System.out.println(staff.getStaffId() + "\t\t" + staff.getStaffName() + "\t\t" + staff.getContactNo());
//        }
        request.setAttribute("staffList", staffList);

        // Forward the request to staff.jsp or any other appropriate JSP file
        request.getRequestDispatcher("staff.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
