package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.RequestDao;

import java.io.IOException;

/**
 * Servlet implementation class DeleteRequestServlet
 */
public class DeleteRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequestServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }

    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Get the request ID parameter from the request
            int requestId = Integer.parseInt(request.getParameter("requestId"));
           

            // Perform deletion of request with the provided request Id using the RequestDao
           RequestDao requestDao = new RequestDao();
            boolean success = requestDao.deleteRequest(requestId);

            // Redirect back to the admin page after deletion
            if (success) {
            	request.getRequestDispatcher("admin0.jsp").forward(request, response);
            } else {
                // Handle deletion failure, maybe display an error message
               response.getWriter().println("Failed to delete request.");
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Forward the request to the doPost() method
            doGet(request, response);
        }
    }

