package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.UserDao;
import net.ayman.model.User;

import java.io.IOException;


public class AddUserServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a new User object with the provided data
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        // Instantiate UserDao and call the addUser method
        UserDao userDao = new UserDao();
        boolean success = userDao.addUser(newUser);

        if (success) {
            // If user creation is successful, redirect to a success page
        	request.getRequestDispatcher("/UserServlet").forward(request, response);
        } else {
            // If user creation fails, redirect to an error page
            String errorMessage = "Failed to add new user. ";
        	request.setAttribute("errorMessage", errorMessage);
        	request.getRequestDispatcher("/UserServlet").forward(request, response);

        }
    }
}

