package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.BorrowModel;

public class BorrowService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    public BorrowService() {
        try {
            dbConn = DbConfig.getDbConnection();
            System.out.println("Connected to DB for borrow");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    public List<BorrowModel> getAllBorrows() {
        if (isConnectionError) {
            System.out.println("Connection Error");
            return null;
        }

        String query = "SELECT borrow_id, user_id, book_id, issued_date, due_date, return_date FROM borrow ORDER BY issued_date DESC";
        List<BorrowModel> borrowList = new ArrayList<>();

        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                BorrowModel borrow = new BorrowModel();
                borrow.setBorrowId(result.getInt("borrow_id"));
                borrow.setUserId(result.getInt("user_id"));
                borrow.setBookId(result.getInt("book_id"));

                LocalDate issuedDate = result.getDate("issued_date").toLocalDate();
                LocalDate dueDate = result.getDate("due_date").toLocalDate();
                LocalDate returnDate = result.getDate("return_date") != null
                        ? result.getDate("return_date").toLocalDate()
                        : null;

                borrow.setIssuedDate(issuedDate);
                borrow.setDueDate(dueDate);
                borrow.setReturnDate(returnDate);

                borrowList.add(borrow);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowList;
    }
}
