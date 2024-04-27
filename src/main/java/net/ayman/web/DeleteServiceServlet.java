package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ServiceDao;
import net.ayman.dao.UserDao;

import java.io.IOException;

/**
 * Servlet implementation class DeleteServiceServlet
 */
public class DeleteServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the user ID to be deleted from the request parameter
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        // Create an instance of UserDao to perform database operations
        ServiceDao serviceDao = new ServiceDao();

        // Attempt to delete the user from the database
        boolean success = serviceDao.deleteService(serviceId);

        // Check if the deletion was successful
        if (success) {
            // If successful, redirect the user to a success page or another appropriate location
        	request.getRequestDispatcher("/ServiceServlet").forward(request, response);
        } else {
            // If deletion failed, handle the error accordingly
        	response.getWriter().println("Failed to delete user.");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the doPost() method
        doGet(request, response);
    }

}
