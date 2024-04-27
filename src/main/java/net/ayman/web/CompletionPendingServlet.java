package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.RequestViewDao;
import net.ayman.model.RequestView;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CompletionPendingServlet
 */
public class CompletionPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletionPendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestViewDao dao = new RequestViewDao();
		List<RequestView> requests = dao.getAllCompletionRequestsView();
		
//		if(requests.isEmpty()) {
//			System.out.print("empth");
//		}

	    // Set the requests attribute in the request object
	    request.setAttribute("requests", requests);
	    request.setAttribute("bothVisible",1);
	    // Forward the request and response to the admin.jsp page
	    request.getRequestDispatcher("completionandstaff.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
