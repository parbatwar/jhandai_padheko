package com.jhandai_padheko.controller.admin;

import com.jhandai_padheko.service.BorrowService;
import com.jhandai_padheko.model.BorrowModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation for handling borrow-related HTTP requests.
 * 
 * This servlet interacts with the BorrowService to fetch all borrow data
 * and forwards it to a JSP page for rendering.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/borrow" })
public class BorrowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instance of BorrowService for handling business logic
	private BorrowService borrowService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowController() {
		this.borrowService = new BorrowService();
	}

	/**
	 * Handles HTTP GET requests by retrieving all borrow records and forwarding
	 * the request to the borrows JSP page.
	 * 
	 * @param request  The HttpServletRequest object containing the request data.
	 * @param response The HttpServletResponse object used to return the response.
	 * @throws ServletException If an error occurs during request processing.
	 * @throws IOException      If an input or output error occurs.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve all borrow records from the service
		List<BorrowModel> borrowList = borrowService.getAllBorrows();

		// Set the list as a request attribute to be used in the JSP
		request.setAttribute("borrowList", borrowList);

		// Forward to JSP page for rendering (adjust path as per your structure)
		request.getRequestDispatcher("/WEB-INF/pages/admin/borrow.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests, currently redirects to GET handler.
	 * 
	 * @param request  The HttpServletRequest object containing the request data.
	 * @param response The HttpServletResponse object used to return the response.
	 * @throws ServletException If an error occurs during request processing.
	 * @throws IOException      If an input or output error occurs.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
