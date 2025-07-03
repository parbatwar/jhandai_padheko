package com.jhandai_padheko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jhandai_padheko.config.DbConfig;
import com.jhandai_padheko.model.PurchaseModel;

public class PurchaseService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	public PurchaseService() {
		try {
			dbConn = DbConfig.getDbConnection();
			System.out.println("Connected to DB for purchase");
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	public List<PurchaseModel> getAllPurchases() {
        if (isConnectionError) {
            System.out.println("Connection Error");
            return null;
        }

        String query = "SELECT p.purchase_id, p.user_id, p.purchase_date,pb.book_id, p.purchase_amount, pb.purchase_quantity FROM purchase p JOIN purchase_books pb ON p.purchase_id = pb.purchase_id ORDER BY p.purchase_date DESC";

        List<PurchaseModel> purchaseList = new ArrayList<>();

        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                PurchaseModel purchase = new PurchaseModel(
                    result.getInt("purchase_id"),
                    result.getInt("user_id"),
                    result.getDate("purchase_date").toLocalDate(),
                    result.getInt("book_id"),
                    result.getDouble("purchase_amount"),
                    result.getInt("purchase_quantity")
                );
                purchaseList.add(purchase);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseList;
    }
}
