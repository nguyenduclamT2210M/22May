package com.example.webappliction.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getMySQLConnection() throws SQLException {
        Connection con = null;
        String host = "localhost";
        String database = "fptaptech2024";
        String name = "root";
        String password = "";
        String connectionURL = "jdbc:mysql://" + host + ":3306/" + database;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connectionURL, name, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
