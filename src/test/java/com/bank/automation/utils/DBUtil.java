package com.bank.automation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    public static ResultSet getOffer(String offerId) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=BankingDB",
                "sa",
                "password"
        );

        Statement stmt = con.createStatement();
        return stmt.executeQuery(
                "SELECT * FROM CreditCardOffers WHERE OfferId='" + offerId + "'"
        );
    }
}
