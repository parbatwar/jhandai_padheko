package com.jhandai_padheko.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jhandai_padheko.model.UserModel;
import com.jhandai_padheko.service.LoginService;
import com.jhandai_padheko.util.CookieUtil;
import com.jhandai_padheko.util.SessionUtil;

/**
 * @author Nikesh Simkhada
 */
@WebServlet(asyncSupported = true, name = "Login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginService loginService;

    public Login() {
        this.loginService = new LoginService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            // If it's admin login, set the role as "admin" in the cookie
            CookieUtil.addCookie(response, "role", "admin", 5 * 30); // Role set as "admin"
            // Set the username and role in the session
            SessionUtil.setAttribute(request, "username", username);
            SessionUtil.setAttribute(request, "role", "admin");

            // Redirect to admin dashboard after admin login
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return; // Exit the method after admin login
        }

        // For regular user login
        UserModel userModel = new UserModel(username, password);
        Boolean loginStatus = loginService.loginUser(userModel);

        if (loginStatus != null && loginStatus) {
            // Successful login for user
            SessionUtil.setAttribute(request, "username", username);
            SessionUtil.setAttribute(request, "loggedIn", true);
            SessionUtil.setAttribute(request, "user", userModel);

            // Set the role as "user" in the cookie
            CookieUtil.addCookie(response, "role", "user", 5 * 30);

            // Redirect to home page for regular users
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        } else {
            // If login fails, handle failure and forward to login page
            handleLoginFailure(request, response, loginStatus);
            return;
        }
    }

    private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus) throws ServletException, IOException {
        String errorMessage;
        if (loginStatus == null) {
            errorMessage = "Our server is under maintenance. Please try again later!";
        } else {
            errorMessage = "User credential mismatch. Please try again!";
        }
        req.setAttribute("error", errorMessage);
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }
}
