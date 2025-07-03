package com.jhandai_padheko.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.BookModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Search
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/search" })
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		List<BookModel> books = new ArrayList<>();

		try {
			Connection dbConn = DbConfig.getDbConnection(); // moved outside try block so it's visible later

			String sql = "SELECT * FROM books WHERE book_title LIKE ? OR book_author LIKE ?";
			try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
				stmt.setString(1, "%" + query + "%");
				stmt.setString(2, "%" + query + "%");

				ResultSet result = stmt.executeQuery();
				while (result.next()) {
					BookModel book = new BookModel();
					book.setBook_id(result.getInt("book_id"));
					book.setBook_title(result.getString("book_title"));
					book.setBook_author(result.getString("book_author"));
					book.setBook_image(result.getString("book_image"));
					book.setBook_price(result.getFloat("book_price"));
					books.add(book);
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		request.setAttribute("bookList", books);
		request.setAttribute("searchQuery", query);
		System.out.println("Search query: " + query);
		System.out.println("Books found: " + books.size());
		for (BookModel b : books) {
			System.out.println(b.getBook_title() + " by " + b.getBook_author());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/books.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}