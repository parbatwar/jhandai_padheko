package com.jhandai_padheko.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jhandai_padheko.service.BookService;
import com.jhandai_padheko.service.BorrowService;
import com.jhandai_padheko.service.DashboardService;

/**
 * Servlet implementation for handling dashboard-related HTTP requests.
 * 
 * This servlet manages interactions with the DashboardService to fetch student
 * information, handle updates, and manage student data. It forwards requests to
 * appropriate JSP pages or handles POST actions based on the request
 * parameters.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/dashboard" })
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instance of DashboardService for handling business logic
	private DashboardService dashboardService;
	private BookService bookService;
	private BorrowService borrowService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardController() {
		this.dashboardService = new DashboardService();
		this.bookService = new BookService();
		this.borrowService = new BorrowService();

	}

	/**
	 * Handles HTTP GET requests by retrieving student information and forwarding
	 * the request to the dashboard JSP page.
	 * 
	 * @param request  The HttpServletRequest object containing the request data.
	 * @param response The HttpServletResponse object used to return the response.
	 * @throws ServletException If an error occurs during request processing.
	 * @throws IOException      If an input or output error occurs.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recent users
		request.setAttribute("userList", dashboardService.getRecentUsers());
		// Book details
		request.setAttribute("bookList", bookService.getAllBooks());
		// Borrow details
		request.setAttribute("borrowList", borrowService.getAllBorrows());
		// E book number
		int ebookCount = new BookService().countEbooks();
		request.setAttribute("ebookCount", ebookCount);
		// Retreive info about books for chart visualization
		request.setAttribute("summaries", dashboardService.getPurchaseSummary());
		// Forward the request to the dashboard JSP for rendering
		request.getRequestDispatcher("/WEB-INF/pages/admin/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}