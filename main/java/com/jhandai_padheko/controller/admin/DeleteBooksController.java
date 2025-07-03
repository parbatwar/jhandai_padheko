package com.jhandai_padheko.controller.admin;

import com.jhandai_padheko.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns={"/deleteBooks"})
public class DeleteBooksController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookIdStr = request.getParameter("bookId");
        System.out.println("[DeleteBooksController] Received bookId param: " + bookIdStr);

        if (bookIdStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                System.out.println("[DeleteBooksController] Parsed bookId: " + bookId);

                boolean deleted = bookService.deleteBook(bookId);
                System.out.println("[DeleteBooksController] Deletion result: " + deleted);

                if (deleted) {
                    response.sendRedirect(request.getContextPath() + "/adminbooks?success=Book+deleted+successfully");
                } else {
                    response.sendRedirect(request.getContextPath() + "/adminbooks?error=Failed+to+delete+book");
                }
            } catch (NumberFormatException e) {
                System.out.println("[DeleteBooksController] Invalid bookId format");
                response.sendRedirect(request.getContextPath() + "/adminbooks?error=Invalid+book+ID+format");
            }
        } else {
            System.out.println("[DeleteBooksController] Missing bookId parameter");
            response.sendRedirect(request.getContextPath() + "/adminbooks?error=Missing+book+ID");
        }
    }
}
