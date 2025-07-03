package com.jhandai_padheko.controller.admin;

import com.jhandai_padheko.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");
        System.out.println("[DeleteUserController] Received userId param: " + userIdStr);

        if (userIdStr != null) {
            try {
                int userId = Integer.parseInt(userIdStr);
                System.out.println("[DeleteUserController] Parsed userId: " + userId);

                boolean deleted = userService.deleteUser(userId);
                System.out.println("[DeleteUserController] Deletion result: " + deleted);

                if (deleted) {
                    response.sendRedirect(request.getContextPath() + "/adminusers?success=User+deleted+successfully");
                } else {
                    // User not found or deletion failed
                    response.sendRedirect(request.getContextPath() + "/user?error=Failed+to+delete+user");
                }
            } catch (NumberFormatException e) {
                System.out.println("[DeleteUserController] Invalid userId format");
                response.sendRedirect(request.getContextPath() + "/user?error=Invalid+user+ID+format");
            }
        } else {
            System.out.println("[DeleteUserController] Missing userId parameter");
            response.sendRedirect(request.getContextPath() + "/user?error=Missing+user+ID");
        }
    }
}