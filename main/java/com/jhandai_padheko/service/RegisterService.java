package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.UserModel;

/**
 * RegisterService handles the registration of new users. 
 * It manages database interactions for user registration.
 */
public class RegisterService {

    private Connection dbConn;

    /**
     * Constructor initializes the database connection.
     */
    public RegisterService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Registers a new user in the database.
     *
     * @param userModel the user details to be registered
     * @return Boolean indicating the success of the operation
     */
    public Boolean addUser(UserModel userModel) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return false;
        }

        String insertQuery = "INSERT INTO users (first_name, last_name, username, dob, gender, email, password, phone, image_path) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {

            // Set user details
            insertStmt.setString(1, userModel.getFirstName());
            insertStmt.setString(2, userModel.getLastName());
            insertStmt.setString(3, userModel.getUsername());
            insertStmt.setDate(4, Date.valueOf(userModel.getDob()));
            insertStmt.setString(5, userModel.getGender());
            insertStmt.setString(6, userModel.getEmail());
            insertStmt.setString(7, userModel.getPassword());
            insertStmt.setString(8, userModel.getPhone());
            insertStmt.setString(9, userModel.getImagePath());

            return insertStmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error during user registration: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
