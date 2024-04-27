package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.RequestDao;
import net.ayman.dao.RequestViewDao;
import net.ayman.model.Request;
import net.ayman.model.RequestView;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CompletionAndStaffServlet
 */
public class CompletionAndStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletionAndStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestViewDao dao = new RequestViewDao();
		List<RequestView> requests = dao.getAllCompletionAndStaffRequestsView();
		
//		if(requests.isEmpty()) {
//			System.out.print("empth");
//		}

	    // Set the requests attribute in the request object
	    request.setAttribute("requests", requests);
	    request.setAttribute("bothVisible",0);

	    // Forward the request and response to the admin.jsp page
	    request.getRequestDispatcher("completionandstaff.jsp").forward(request, response);
		
		
//
//		// Check if the list is not empty
//		if (!requests.isEmpty()) {
//		    // Iterate over the list and print each request
//		    for (RequestView request1 : requests) {
//		        System.out.println("Request ID: " + request1.getRequestId());
//		        System.out.println("User ID: " + request1.getUserId());
//		        System.out.println("Date of Request: " + request1.getDateOfRequest());
//		        System.out.println("Location: " + request1.getLocation());
//		        System.out.println("Status: " + request1.getStatus());
//		        System.out.println("Date of Completion: " + request1.getDateOfCompletion());
//		        System.out.println("Staff ID: " + request1.getStaffId());
//		        System.out.println("Service Name: " + request1.getServiceName());
//		        // Print additional attributes as needed
//		        System.out.println("-----------------------------------");
//		    }
//		} else {
//		    System.out.println("No pending requests with completion and staff assignments found.");
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
