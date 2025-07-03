package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.UserModel;

public class ProfileService {

    private Connection dbConn;

    public ProfileService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Retrieves the full user profile from the database using the username.
     *
     * @param username the username of the user
     * @return a UserModel containing user details, or null if not found
     */
    public UserModel getUserProfile(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                // Convert sql.Date to LocalDate
                java.sql.Date sqlDate = result.getDate("dob");
                LocalDate dob = sqlDate != null ? sqlDate.toLocalDate() : null;

                // Retrieve image path from the database
                String imagePath = result.getString("image_path");

                // Create and return a UserModel object with all user details, including the image path
                return new UserModel(
                    result.getInt("user_id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("username"),
                    dob,  // Set the LocalDate for dob
                    result.getString("gender"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("phone"),
                    imagePath  // Set the image path
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;  // If user is not found
    }
}
