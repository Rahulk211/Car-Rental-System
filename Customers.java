package com.carrentalsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customers {
    private Connection conn;

    public Customers(){
        conn =DatabaseConnectors.getConnection();
    }

    public void addCustomers(String customer_name, String phone, String licence_number){
        String qy = "insert into Customer(customer_name, phone, licence_number) values(?,?,?)";
        try(
            PreparedStatement pstmt = conn.prepareStatement(qy);
        ){
            pstmt.setString(1, customer_name);
            pstmt.setString(2, phone);
            pstmt.setString(3, licence_number);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listAllCustomers(){
        String qy = "select * from Customer";
        try(
            PreparedStatement pstmt = conn.prepareStatement(qy);
        ){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("customer_name") + " " + rs.getString("phone") +
                " " + rs.getString("licence_number"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getCustomerId(String customer_name){
        String qy = "select id from Customer where customer_name = ?";
        try(
            PreparedStatement pstmt = conn.prepareStatement(qy);
        ){
            pstmt.setString(1, customer_name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
