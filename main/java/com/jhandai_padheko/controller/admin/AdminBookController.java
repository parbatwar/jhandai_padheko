package com.jhandai_padheko.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jhandai_padheko.service.BookService;

/**
 * Servlet implementation class AdminBookController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/adminbooks" })
public class AdminBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService BookService;
	
	public AdminBookController() {
		this.BookService = new BookService();
	}
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("bookList", BookService.getAllBooks());
		
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminbooks.jsp").forward(request, response);
	}
}