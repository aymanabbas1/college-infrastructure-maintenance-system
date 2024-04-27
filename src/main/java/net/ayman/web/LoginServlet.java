package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.UserDao;
import net.ayman.model.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assuming you have a UserDao instance
        UserDao userDao = new UserDao();

        // Check if the user exists in the database
        int user = userDao.validateUser(username,password);
        
      
        
        if(username.equals("admin") && password.equals("admin")) {
        	request.getRequestDispatcher("admin0.jsp").forward(request, response);
        }
//        else if (user != null && user.getPassword().equals(password)) {
            
//        
//        } 
        else if(user == 1) {
        	// If login is successful, forward the request and response to admin.jsp
            request.getRequestDispatcher("locationform.jsp").forward(request, response);
        }
        
        
        else {
            // If login fails, forward the request and response to login.jsp with an error message
            request.setAttribute("errorMessage", "Invalid username or password. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


}
