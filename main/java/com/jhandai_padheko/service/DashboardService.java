package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.PurchaseSummary;
import com.jhandai_padheko.model.UserModel;
import com.jhandai_padheko.model.BookModel;

/**
 * Service class for interacting with the database to retrieve dashboard-related
 * data. This class handles database connections and performs queries to fetch
 * user information.
 */
public class DashboardService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Constructor that initializes the database connection. Sets the connection
     * error flag if the connection fails.
     */
    public DashboardService() {
        try {
            dbConn = DbConfig.getDbConnection();
            System.out.println("Connected");
        } catch (SQLException | ClassNotFoundException ex) {
            // Log and handle exceptions related to database connection
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Retrieves all user information from the database.
     * 
     * @return A list of UserModel objects containing user data. Returns an empty
     *         list if there is a connection error or if an exception occurs during query
     *         execution.
     */
    public List<UserModel> getAllUsersInfo() {
        if (isConnectionError) {
            System.out.println("Connection Error");
            return null;
        }
        // Query to fetch user info
        String query = "SELECT user_id, first_name, last_name, username, gender, email, phone FROM users";
        System.out.println("Getting users...");
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();
            
            List<UserModel> userList = new ArrayList<>();
            while (result.next()) {
            	//Creation and addition of info to the list
                userList.add(new UserModel(
                    result.getInt("user_id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("username"),
                    result.getString("gender"),
                    result.getString("email"),
                    result.getString("phone")
                ));
            }

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<UserModel> getRecentUsers() {
        if (isConnectionError) {
            System.out.println("Connection Error");
            return null;
        }

        // Query to get 5 most recent users (ordered by user_id descending)
        String query = "SELECT user_id, first_name, last_name, username, gender, email, phone FROM users ORDER BY user_id DESC LIMIT 5";
        System.out.println("Getting recent users...");
        
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();

            List<UserModel> recentUsers = new ArrayList<>();
            while (result.next()) {
                recentUsers.add(new UserModel(
                    result.getInt("user_id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("username"),
                    result.getString("gender"),
                    result.getString("email"),
                    result.getString("phone")
                ));
            }

            return recentUsers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PurchaseSummary> getPurchaseSummary() {
        if (isConnectionError) {
            System.out.println("Connection Error");
            return new ArrayList<>();
        }

        String sql = "SELECT DATE(purchase_date) AS date, SUM(purchase_amount) AS total_amount " +
                     "FROM purchase GROUP BY DATE(purchase_date)";
        List<PurchaseSummary> summaries = new ArrayList<>();

        try (PreparedStatement ps = dbConn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	summaries.add(new PurchaseSummary(
            		rs.getTimestamp("date"),
                    rs.getInt("total_amount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return summaries;
    }
}