package com.jhandai_padheko.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jhandai_padheko.service.DashboardService;
import com.jhandai_padheko.service.UserService;

/**
 * Servlet implementation for handling dashboard-related HTTP requests.
 * 
 * This servlet manages interactions with the DashboardService to fetch student
 * information, handle updates, and manage student data. It forwards requests to
 * appropriate JSP pages or handles POST actions based on the request
 * parameters.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/adminusers" })
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instance of DashboardService for handling business logic
	private DashboardService dashboardService;
	private UserService userService;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUserController() {
		this.dashboardService = new DashboardService();
		this.userService = new UserService();
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
		// Retrieve all student information from the DashboardService
		request.setAttribute("userList", dashboardService.getAllUsersInfo());

		// Forward the request to the dashboard JSP for rendering
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminusers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * 
	 * @Override
	 * protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");
	    String userIdParam = request.getParameter("user_id");

	    if (userIdParam == null || userIdParam.isEmpty()) {
	        response.sendRedirect(request.getContextPath() + "/adminusers");
	        return;
	    }

	    int userId = Integer.parseInt(userIdParam);

	    if (action.equalsIgnoreCase("edit")) {
	        // redirect to edit form or forward with user data
	        request.setAttribute("user", userService.getUserById(userId));
	        request.getRequestDispatcher("/WEB-INF/pages/admin/update.jsp").forward(request, response);
	    } else if (action.equalsIgnoreCase("delete")) {
	        dashboardService.deleteUserbyId(userId);
	        response.sendRedirect(request.getContextPath() + "/adminusers"); // refresh the list
	    } else {
	        response.sendRedirect(request.getContextPath() + "/adminusers");
	    }
	}
	 */
}