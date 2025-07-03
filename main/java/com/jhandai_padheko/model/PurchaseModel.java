package com.jhandai_padheko.model;

import java.time.LocalDate;

public class PurchaseModel {
	private int purchase_id;
	private int user_id;
	private LocalDate purchase_date;
	private int book_id;
	private double purchase_amount;
	private int purchase_quantity;

	// Constructor
	public PurchaseModel(int purchase_id, int user_id, LocalDate purchase_date, int book_id, double purchase_amount,
			int purchase_quantity) {
		this.purchase_id = purchase_id;
		this.user_id = user_id;
		this.purchase_date = purchase_date;
		this.book_id = book_id;
		this.purchase_amount = purchase_amount;
		this.purchase_quantity = purchase_quantity;
	}

	// Getters
	public int getPurchaseId() {
		return purchase_id;
	}

	public int getUserId() {
		return user_id;
	}

	public LocalDate getPurchaseDate() {
		return purchase_date;
	}

	public int getBookId() {
		return book_id;
	}

	public double getPurchaseAmount() {
		return purchase_amount;
	}

	public int getPurchaseQuantity() {
		return purchase_quantity;
	}
}
