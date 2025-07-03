package com.jhandai_padheko.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jhandai_padheko.util.SessionUtil;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private static final String LOGIN = "/login";
	private static final String REGISTER = "/register";
	private static final String HOME = "/index";
	private static final String DASHBOARD = "/dashboard";
	private static final String BORROW = "/borrow";
	private static final String PURCHASE = "/purchase";
	private static final String BOOKS = "/adminbooks";
	private static final String USERS = "/adminusers";
	private static final String UPDATE = "/update";
	private static final String PROFILE = "/profile";
	private static final String REPORT = "/generateUserReport";
	private static final String UPDATEBOOKS = "/updatebooks";
	private static final String DELETEBOOKS = "/deleteBooks";	
	private static final String DELETEUSERS = "/deleteUser";	

	private static final String ROOT = "/";
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic if required
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		// Skip certain URLs (like login, register, home) for everyone
		if (uri.endsWith(".css") || uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(DASHBOARD)
				|| uri.endsWith(BORROW) || uri.endsWith(PROFILE) || uri.endsWith(REPORT) || uri.endsWith(USERS)
				|| uri.endsWith(PURCHASE) || uri.endsWith(UPDATEBOOKS) || uri.endsWith(DELETEBOOKS) || uri.endsWith(DELETEUSERS) || uri.endsWith(BOOKS) || uri.endsWith(UPDATE) || uri.endsWith(".png")
				|| uri.contains("/resources/")) {
			chain.doFilter(request, response);
			return;
		}

		// Allow access to login, register, and home page
		if (uri.endsWith("/login") || uri.endsWith("/register") || uri.endsWith("/index")
				|| uri.equals(req.getContextPath() + "/")) {
			chain.doFilter(request, response);
			return;
		}

		// Get the session and check if the user is logged in and get their role
		Boolean isLoggedIn = (Boolean) SessionUtil.getAttribute(req, "loggedIn");
		String userRole = (String) SessionUtil.getAttribute(req, "role");

		// If the user is logged in
		if (isLoggedIn != null && isLoggedIn) {
			// Admin-specific access: Ensure that only admins can access admin pages
			if (uri.contains("/admin") || uri.contains("/admin")) {
				if ("admin".equals(userRole)) {
					chain.doFilter(request, response); // Allow admin access
				} else {
					res.sendRedirect(req.getContextPath() + HOME); // Redirect non-admins to home page
					return;
				}
			} else {
				chain.doFilter(request, response); // Allow access to regular pages for any user
			}
		} else {
			// If not logged in, redirect to login page
			res.sendRedirect(req.getContextPath() + LOGIN);
		}
	}

	@Override
	public void destroy() {
		// Cleanup logic if required
	}
}