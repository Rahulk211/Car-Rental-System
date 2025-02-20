package com.carrentalsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRentalSys {

    private Connection conn;

    public CarRentalSys() {
        this.conn = DatabaseConnectors.getConnection();
    }

    public void addCars(String cars_model, String cars_brand, double cars_price) {
        if (conn == null) {
            System.out.println("Database connection not available.");
            return;
        }
        String query = "INSERT INTO Cars (cars_model, cars_brand, cars_price, cars_status) values(?,?,?, true)";
        try (
                PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, cars_model);
            pstmt.setString(2, cars_brand);
            pstmt.setDouble(3, cars_price);

            pstmt.executeUpdate();
            System.out.println("Car added to the database successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int cars_id) {
        String query = "delete from Cars where cars_id = ?";
        try (
                PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1, cars_id);
            pstmt.executeUpdate();
            System.out.println("Car deleted from the database successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listAllCars() {
        String query = "SELECT * FROM Cars";
        try (
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("cars_model") + " " + rs.getString("cars_brand")
                        + " " + rs.getBoolean("cars_status") + " " + rs.getDouble("cars_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(int cars_id, boolean status) {
        String query = "update Cars set cars_status =? where cars_id = ?";
        try (
                PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setBoolean(1, status);
            pstmt.setInt(2, cars_id);
            pstmt.executeUpdate();
            System.out.println("Car status updated successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
