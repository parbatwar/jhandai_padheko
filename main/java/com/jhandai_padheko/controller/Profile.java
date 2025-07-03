package com.jhandai_padheko.controller;

import com.jhandai_padheko.model.UserModel;
import com.jhandai_padheko.service.ProfileService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
public class Profile extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProfileService profileService = new ProfileService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the username from session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // Redirect to login if not logged in
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");

        // Fetch the user profile data
        UserModel user = profileService.getUserProfile(username);

        if (user == null) {
            request.setAttribute("errorMessage", "User not found");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            return;
        }

        // Set user data to request scope
        request.setAttribute("user", user);

        // Forward to profile view JSP
        request.getRequestDispatcher("/WEB-INF/pages/profileview.jsp").forward(request, response);
    }
}
