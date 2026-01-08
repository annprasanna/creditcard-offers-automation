package com.bank.automation.utils;

import java.sql.*;

public class DBUtil {

    public static String getCardTypeByEligibility(String eligibility) {

        String cardType = null;

        try (Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=BankingDB;encrypt=false",
                "sa",
                "password")) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT CardType FROM CreditCardOffers WHERE Eligibility = ?");

            ps.setString(1, eligibility);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cardType = rs.getString("CardType");
            }

        } catch (Exception e) {
            throw new RuntimeException("DB validation failed", e);
        }

        return cardType;
    }
}
