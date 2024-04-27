package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SubmitLocation
 */
public class SubmitLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String area = request.getParameter("area");
	        String location = request.getParameter("location");
	        String floor = request.getParameter("floor");
	        String username = request.getParameter("username");
	        
	        String nextPage = ""; // Path to the next JSP page
	        
	        if (area.equals("Washroom")) {
	            nextPage = "washroom.jsp";
	        } else if (area.equals("Classroom")) {
	            nextPage = "classroom.jsp";
	        } else if (area.equals("Hallways")) {
	            nextPage = "hallways.jsp";
	        }
	        
	        // Forward the request to the appropriate JSP page
	        request.setAttribute("location", location);
	        request.setAttribute("area",area);
	        request.setAttribute("floor", floor);
	        request.setAttribute("username", username);
	        request.getRequestDispatcher(nextPage).forward(request, response);
	    }

}
