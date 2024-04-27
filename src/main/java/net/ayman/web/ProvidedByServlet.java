package net.ayman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ayman.dao.ProvidedByDao;
import net.ayman.model.ProvidedBy;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ProvidedByServlet
 */
public class ProvidedByServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvidedByServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProvidedByDao providedByDao = new ProvidedByDao();
        // Use your DAO to fetch providedBy data from the database
        List<ProvidedBy> providedByList = providedByDao.getAllProvidedBy(); // Assuming providedByDao is already initialized

        // Set the providedBy list as a request attribute
        request.setAttribute("providedByList", providedByList);

        // Forward the request to providedBy.jsp
        request.getRequestDispatcher("providedBy.jsp").forward(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
