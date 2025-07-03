package com.jhandai_padheko.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet(urlPatterns = {"/generateUserReport"})


public class ReportController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String jdbcURL = "jdbc:mysql://localhost:3306/jhandai_padheko";
        String dbUser = "root";
        String dbPass = "";

        int totalBooks = 0, totalEbooks = 0, totalUsers = 0, totalAdmins = 0, maleUsers = 0, femaleUsers = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPass);

            Statement stmt = con.createStatement();

            ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM books");
            if (rs1.next()) totalBooks = rs1.getInt(1);

            ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM books WHERE book_type = 'e-book'");
            if (rs2.next()) totalEbooks = rs2.getInt(1);

            ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM users WHERE role = 'user'");
            if (rs3.next()) totalUsers = rs3.getInt(1);

            ResultSet rs4 = stmt.executeQuery("SELECT COUNT(*) FROM users WHERE role = 'admin'");
            if (rs4.next()) totalAdmins = rs4.getInt(1);

            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) FROM users WHERE gender = 'male' AND role = 'user'");
            if (rs5.next()) maleUsers = rs5.getInt(1);

            ResultSet rs6 = stmt.executeQuery("SELECT COUNT(*) FROM users WHERE gender = 'female' AND role = 'user'");
            if (rs6.next()) femaleUsers = rs6.getInt(1);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("totalBooks", totalBooks);
        request.setAttribute("totalEbooks", totalEbooks);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalAdmins", totalAdmins);
        request.setAttribute("maleUsers", maleUsers);
        request.setAttribute("femaleUsers", femaleUsers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/admin/report.jsp");
        dispatcher.forward(request, response);
    }
}