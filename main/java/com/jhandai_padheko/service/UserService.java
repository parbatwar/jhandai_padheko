package com.jhandai_padheko.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.UserModel;

public class UserService {
    private Connection dbConn;
    private boolean isConnectionError = false;

    public UserService() {
        try {
            dbConn = DbConfig.getDbConnection();
            System.out.println("Connected to DB for users");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    public List<UserModel> getAllUsers() {
        if (isConnectionError) {
            System.out.println("Connection Error");
            return null;
        }

        List<UserModel> userList = new ArrayList<>();
        String query = "SELECT * FROM users ORDER BY user_id ASC";

        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                UserModel user = new UserModel(
                    result.getInt("user_id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("username"),
                    result.getDate("dob").toLocalDate(),
                    result.getString("gender"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("phone")
                );
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public boolean updateUser(UserModel user) {
        String query = "UPDATE users SET first_name = ?, last_name = ?, username = ?, dob = ?, gender = ?, email = ?, phone = ? WHERE user_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setDate(4, java.sql.Date.valueOf(user.getDob()));
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getPhone());
            stmt.setInt(8, user.getUser_id());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public UserModel getUserById(int user_id) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, user_id);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    return new UserModel(
                        result.getInt("user_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("username"),
                        result.getDate("dob").toLocalDate(),
                        result.getString("gender"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // if user not found or error occurs
    }
    
    public boolean deleteUser(int userId) {
        System.out.println("Attempting to delete user with ID: " + userId);
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}