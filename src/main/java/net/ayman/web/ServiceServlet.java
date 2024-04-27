package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ServiceDao;
import net.ayman.dao.UserDao;
import net.ayman.model.Service;
import net.ayman.model.User;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ServiceServlet
 */
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceDao serviceDao = new ServiceDao();
        // Use your DAO to fetch user data from the database
        List<Service> services = serviceDao.getAllServices(); // Assuming userDao is already initialized
        
        // Set the users list as a request attribute
        request.setAttribute("services", services);
        
        // Forward the request to users.jsp
        request.getRequestDispatcher("service.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
