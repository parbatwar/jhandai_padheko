package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.jhandai_padheko.model.BookModel;
import com.jhandai_padheko.config.DbConfig;

public class BookService {
    private Connection dbConn;
    private boolean isConnectionError = false;

    public BookService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
            isConnectionError = true;
        }
    }

    public List<BookModel> getAllBooks() {
        List<BookModel> books = new ArrayList<>();
        if (isConnectionError) return books;

        String query = "SELECT * FROM books";
        try (Statement stmt = dbConn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                BookModel book = new BookModel();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_title(rs.getString("book_title"));
                book.setBook_author(rs.getString("book_author"));
                book.setBook_genre(rs.getString("book_genre"));
                book.setBook_condition(rs.getString("book_condition"));
                book.setBook_price(rs.getFloat("book_price"));
                book.setBook_quantity(rs.getInt("book_quantity"));
                book.setBook_type(rs.getString("book_type"));
                book.setBook_image(rs.getString("book_image"));
                book.setDescription(rs.getString("description"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public BookModel getBookById(int id) {
        if (isConnectionError) return null;

        String query = "SELECT * FROM books WHERE book_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BookModel book = new BookModel();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_title(rs.getString("book_title"));
                book.setBook_author(rs.getString("book_author"));
                book.setBook_genre(rs.getString("book_genre"));
                book.setBook_condition(rs.getString("book_condition"));
                book.setBook_price(rs.getFloat("book_price"));
                book.setBook_quantity(rs.getInt("book_quantity"));
                book.setBook_type(rs.getString("book_type"));
                book.setBook_image(rs.getString("book_image"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addBook(BookModel book) {
        if (isConnectionError) return false;

        String insertSQL = "INSERT INTO books (book_title, book_author, book_genre, book_condition, book_price, book_quantity, book_type, book_image, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dbConn.prepareStatement(insertSQL)) {
            stmt.setString(1, book.getBook_title());
            stmt.setString(2, book.getBook_author());
            stmt.setString(3, book.getBook_genre());
            stmt.setString(4, book.getBook_condition());
            stmt.setFloat(5, book.getBook_price());
            stmt.setInt(6, book.getBook_quantity());
            stmt.setString(7, book.getBook_type());
            stmt.setString(8, book.getBook_image());
            stmt.setString(9, book.getDescription());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateBook(BookModel book) {
        if (isConnectionError) return false;

        String updateSQL = "UPDATE books SET book_title = ?, book_author = ?, book_genre = ?, book_condition = ?, book_price = ?, book_quantity = ?, book_type = ?, book_image = ?, description = ? WHERE book_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(updateSQL)) {
            stmt.setString(1, book.getBook_title());
            stmt.setString(2, book.getBook_author());
            stmt.setString(3, book.getBook_genre());
            stmt.setString(4, book.getBook_condition());
            stmt.setFloat(5, book.getBook_price());
            stmt.setInt(6, book.getBook_quantity());
            stmt.setString(7, book.getBook_type());
            stmt.setString(8, book.getBook_image());
            stmt.setString(9, book.getDescription());
            stmt.setInt(10, book.getBook_id());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteBook(int id) {
        if (isConnectionError) return false;

        String deleteSQL = "DELETE FROM books WHERE book_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(deleteSQL)) {
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public int countEbooks() {
        if (isConnectionError) return 0;

        String query = "SELECT COUNT(*) AS ebook_count FROM books WHERE book_type = 'e-book'";
        try (Statement stmt = dbConn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt("ebook_count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}