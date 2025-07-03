package com.jhandai_padheko.controller.admin;

import java.io.IOException;
import java.time.LocalDate;

import com.jhandai_padheko.model.UserModel;
import com.jhandai_padheko.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    // Show the edit form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");
        if (userIdStr != null) {
            int userId = Integer.parseInt(userIdStr);
            UserModel user = userService.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/pages/admin/update.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/users");
        }
    }

    // Process the update form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        UserModel updatedUser = new UserModel();
        updatedUser.setUser_id(userId);
        updatedUser.setFirstName(firstName);
        updatedUser.setLastName(lastName);
        updatedUser.setUsername(username);
        updatedUser.setDob(dob);
        updatedUser.setGender(gender);
        updatedUser.setEmail(email);
        updatedUser.setPhone(phone);

        boolean isUpdated = userService.updateUser(updatedUser);

        if (isUpdated) {
            // Redirect to users list page with success message
        	response.sendRedirect(request.getContextPath() + "/adminusers?success=User+updated+successfully");

        } else {
            // If update fails, stay on update page and show error
            request.setAttribute("error", "Update failed");
            request.setAttribute("user", updatedUser);
            request.getRequestDispatcher("/WEB-INF/pages/admin/update.jsp").forward(request, response);
        }
    }
}