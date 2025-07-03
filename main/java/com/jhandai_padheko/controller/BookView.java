package com.jhandai_padheko.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jhandai_padheko.model.BookModel;
import com.jhandai_padheko.service.BookService;

/**
 * @author Nikesh Simkhada
 */
@WebServlet(asyncSupported = true, name = "BookView", urlPatterns = { "/bookview"})

public class BookView extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        bookService = new BookService(); // initialize the service
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String book_id_str = request.getParameter("book_id");
        int book_id = Integer.parseInt(book_id_str.trim());
        if (book_id_str == null || book_id_str.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book ID is missing.");
            return;
        }
        

        // Fetch book details from service
        BookModel book = bookService.getBookById(book_id);

        if (book == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found.");
            return;
        }

        // Set book details
        request.setAttribute("book", book);
       

        // Forward to JSP page
        request.getRequestDispatcher("/WEB-INF/pages/bookview.jsp").forward(request, response);
    }
}