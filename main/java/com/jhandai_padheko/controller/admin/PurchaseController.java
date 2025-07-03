package com.jhandai_padheko.controller.admin;

import com.jhandai_padheko.service.PurchaseService;
import com.jhandai_padheko.model.PurchaseModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation for handling purchase-related HTTP requests.
 * 
 * This servlet interacts with the PurchaseService to fetch all purchase data
 * and forwards it to a JSP page for rendering.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/purchase" })
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instance of PurchaseService for handling business logic
	private PurchaseService purchaseService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseController() {
		this.purchaseService = new PurchaseService();
	}

	/**
	 * Handles HTTP GET requests by retrieving all purchases and forwarding
	 * the request to the purchases JSP page.
	 * 
	 * @param request  The HttpServletRequest object containing the request data.
	 * @param response The HttpServletResponse object used to return the response.
	 * @throws ServletException If an error occurs during request processing.
	 * @throws IOException      If an input or output error occurs.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve all purchase records from the service
		List<PurchaseModel> purchaseList = purchaseService.getAllPurchases();

		// Set the list as a request attribute to be used in the JSP
		request.setAttribute("purchaseList", purchaseList);

		// Forward to JSP page for rendering (adjust path as per your structure)
		request.getRequestDispatcher("/WEB-INF/pages/admin/purchase.jsp").forward(request, response);
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
