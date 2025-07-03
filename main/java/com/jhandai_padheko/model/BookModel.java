package com.jhandai_padheko.model;

public class BookModel {

	private int book_id;
	private String book_title;
	private String book_author;
	private String book_genre;
	private String book_condition;
	private float book_price;
	private int book_quantity;
	private String book_type;
	private String book_image;
	private String description; // new field for book description

	public BookModel() {
	}

	public BookModel(int book_id, String book_title, String book_author, String book_genre, String book_condition,
			float book_price, int book_quantity, String book_type, String book_image, String description) {
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_genre = book_genre;
		this.book_condition = book_condition;
		this.book_price = book_price;
		this.book_quantity = book_quantity;
		this.book_type = book_type;
		this.book_image = book_image;
		this.description = description;
	}

	public BookModel(String book_title, String book_author, String book_genre, String book_condition,
			float book_price, int book_quantity, String book_type) {
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_genre = book_genre;
		this.book_condition = book_condition;
		this.book_price = book_price;
		this.book_quantity = book_quantity;
		this.book_type = book_type;
	}
	public BookModel(int book_id, String book_title, String book_author, String book_genre, String book_condition,
			float book_price, int book_quantity, String book_type) {
		this.book_title = book_title;
		this.book_id = book_id;
		this.book_author = book_author;
		this.book_genre = book_genre;
		this.book_condition = book_condition;
		this.book_price = book_price;
		this.book_quantity = book_quantity;
		this.book_type = book_type;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_genre() {
		return book_genre;
	}

	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}

	public String getBook_condition() {
		return book_condition;
	}

	public void setBook_condition(String book_condition) {
		this.book_condition = book_condition;
	}

	public float getBook_price() {
		return book_price;
	}

	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}

	public int getBook_quantity() {
		return book_quantity;
	}

	public void setBook_quantity(int book_quantity) {
		this.book_quantity = book_quantity;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}