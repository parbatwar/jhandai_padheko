package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.UserModel;
import com.jhandai_padheko.model.BookModel;

/**
 * Service class for updating user information in the database.
 * 
 * This class provides methods to update student details and fetch program IDs
 * from the database. It manages database connections and handles SQL
 * exceptions.
 */
public class UpdateService {
	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public UpdateService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			// Log and handle exceptions related to database connection
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Updates user information in the database.
	 * 
	 * @param user The UserModel object containing the updated user data.
	 * @return Boolean indicating the success of the update operation. Returns null
	 *         if there is a connection error or an exception occurs.
	 */
	public Boolean updateUserInfo(UserModel user) {
		if (isConnectionError) {
			return null;
		}

		String updateSQL = "UPDATE users SET first_name = ?, last_name = ?, username = ?, gender = ?, email = ?, number = ? WHERE user_id = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL)) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPhone());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Log and handle SQL exceptions
			e.printStackTrace();
			return null;
		}
	}

	public Boolean deleteUserInfo(UserModel user) {
		if (isConnectionError) {
			return null;
		}

		String deleteSQL = "Delete from users where user_id = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(deleteSQL)) {
			preparedStatement.setInt(1, user.getUser_id());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Log and handle SQL exceptions
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean updateBookInfo(BookModel book) {
		if (isConnectionError) {
			return null;
		}

		String updateSQL = "UPDATE books SET title = ?, author = ?, genre = ?, condition = ?, price = ?, quantity = ?, type = ? WHERE book_id = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL)) {
			preparedStatement.setString(1, book.getBook_title());
			preparedStatement.setString(2, book.getBook_author());
			preparedStatement.setString(3, book.getBook_genre());
			preparedStatement.setString(4, book.getBook_condition());
			preparedStatement.setFloat(5, book.getBook_price());
			preparedStatement.setInt(6, book.getBook_quantity());
			preparedStatement.setString(7, book.getBook_type());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Log and handle SQL exceptions
			e.printStackTrace();
			return null;
		}
	}

	public Boolean deleteBookInfo(BookModel book) {
		if (isConnectionError) {
			return null;
		}

		String deleteSQL = "Delete from books where book_id = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(deleteSQL)) {
			preparedStatement.setInt(1, book.getBook_id());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Log and handle SQL exceptions
			e.printStackTrace();
			return null;
		}
	}
}