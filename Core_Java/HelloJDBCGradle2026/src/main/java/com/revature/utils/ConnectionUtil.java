package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This is what we'll use to manage our connection to the database
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        //For compatibility with other technologies/frameworks will need to register our Driver
        //This process makes the application aware of what Driver class we're using
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Hardcoded! Bad!!
        //You can hide these in environment variables but I won't for this demo
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=p1demo";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);

    }

}
