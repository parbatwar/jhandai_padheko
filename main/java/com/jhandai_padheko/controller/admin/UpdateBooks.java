package com.jhandai_padheko.controller.admin;

import java.io.IOException;

import com.jhandai_padheko.model.BookModel;
import com.jhandai_padheko.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns={"/updatebooks"})
public class UpdateBooks extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookService();

    // Show the edit book form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdStr = request.getParameter("bookId");
        if (bookIdStr != null) {
            int bookId = Integer.parseInt(bookIdStr);
            BookModel book = bookService.getBookById(bookId);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/WEB-INF/pages/admin/updatebooks.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/adminbooks");
        }
    }

    // Process the update book form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String title = request.getParameter("bookTitle");
        String author = request.getParameter("bookAuthor");
        String genre = request.getParameter("bookGenre");
        String condition = request.getParameter("bookCondition");
        float price = Float.parseFloat(request.getParameter("bookPrice"));
        int quantity = Integer.parseInt(request.getParameter("bookQuantity"));
        String type = request.getParameter("bookType");
        String image = request.getParameter("bookImage");
        String description = request.getParameter("description");

        BookModel updatedBook = new BookModel();
        updatedBook.setBook_id(bookId);
        updatedBook.setBook_title(title);
        updatedBook.setBook_author(author);
        updatedBook.setBook_genre(genre);
        updatedBook.setBook_condition(condition);
        updatedBook.setBook_price(price);
        updatedBook.setBook_quantity(quantity);
        updatedBook.setBook_type(type);
        updatedBook.setBook_image(image);
        updatedBook.setDescription(description);

        boolean isUpdated = bookService.updateBook(updatedBook);

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/adminbooks?success=Book+updated+successfully");
        } else {
            request.setAttribute("error", "Update failed");
            request.setAttribute("book", updatedBook);
            request.getRequestDispatcher("/WEB-INF/pages/admin/updatebooks.jsp").forward(request, response);
        }
    }
}
