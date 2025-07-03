package com.jhandai_padheko.model;

import java.time.LocalDate;

public class BorrowModel {
    private int borrowId;
    private int userId;
    private int bookId;
    private LocalDate issuedDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    // Default constructor
    public BorrowModel() {}

    // Constructor with all fields (except returnDate, which may be null initially)
    public BorrowModel(int borrowId, int userId, int bookId, LocalDate issuedDate, LocalDate dueDate, LocalDate returnDate) {
        this.borrowId = borrowId;
        this.userId = userId;
        this.bookId = bookId;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    // Constructor without borrowId (useful for inserting new records)
    public BorrowModel(int userId, int bookId, LocalDate issuedDate, LocalDate dueDate, LocalDate returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
