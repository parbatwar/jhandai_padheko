package com.jhandai_padheko.model;

public class CartItem {
    private BookModel book;
    private int quantity;

    public CartItem(BookModel book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public BookModel getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return quantity * book.getBook_price();
    }
}