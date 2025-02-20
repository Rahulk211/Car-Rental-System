package com.carrentalsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectors {
    private static final String URL = "jdbc:mysql://localhost:3306/CarRentalDB?user=root&password=admin@1234";
    private static final String USER = "root";
    private static final String PASSWORD = "admin@1234";

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to database!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Error connecting to database");
            return null;
        }
        return null;
    }
}
