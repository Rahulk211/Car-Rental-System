package com.carrentalsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Rental {
    private Connection conn;
    private CarRentalSys cars;

    public Rental(){
        conn = DatabaseConnectors.getConnection();
        cars = new CarRentalSys();
    }

    public void rentCar(int customer_id, int cars_id, int rental_days){
        // rental logic here
        String updatecars = "update Cars set cars_status = false where cars_id = ? " ;
        String insertcar = "insert into Reatal (customer_id, cars_id, rental_date, return_date, total_price) values(?,?,?,?,?)";

        try(
            PreparedStatement pstmt = conn.prepareStatement(updatecars);
            PreparedStatement pstmt2 = conn.prepareStatement(insertcar);
        ){
            if (!isCarAvailable(cars_id)) {
                System.out.println("Car is not available for rent.");
                return;
            }
            pstmt.setInt(1, cars_id);
            pstmt.executeUpdate();


            pstmt2.setInt(1, customer_id);
            pstmt2.setInt(2, cars_id);
            LocalDate rentalDate = LocalDate.now();
            pstmt2.setDate(3, java.sql.Date.valueOf(rentalDate));
            LocalDate returndDate = rentalDate.plusDays(rental_days);
            pstmt2.setDate(4, java.sql.Date.valueOf(returndDate));

            double daily_price = getCarsPrice(cars_id);
            double total_price = daily_price * rental_days;
            pstmt2.setDouble(5, total_price);

            pstmt2.executeUpdate();
            

            pstmt2.executeUpdate();
            
            System.out.println("Car rented successfully for " + rental_days + " days. Total cost: $" + total_price);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private boolean isCarAvailable(int cars_id){
        String query = "SELECT cars_status FROM Cars WHERE cars_id = ?";

        try(
            PreparedStatement pstmt = conn.prepareStatement(query);
        ){
            pstmt.setInt(1, cars_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getBoolean("Avaliable");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    private double getCarsPrice(int cars_id){
        String query = "select cars_price from Cars where cars_id = ?";

        try(
            PreparedStatement pstmt = conn.prepareStatement(query);
        ){
            pstmt.setInt(1, cars_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("cars_price");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0.0;
    }

    public void returnCar(int cars_id){
        if(isCarAvailable(cars_id)){
            System.out.println("Car is already avaliable");
            return;
        }
        String query = "update Cars_Avaliability set avaliable = true where cars_id = ?";
    
        try(
            PreparedStatement stmt = conn.prepareStatement(query);
        ){
            stmt.setInt(1, cars_id);
            stmt.executeUpdate();
            
            cars.updateStatus(cars_id,true);

            System.out.println("Car returned successfully and is now available.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void getRentedCars(){
        String query = "select * from Rented";
        try(
            PreparedStatement stmt = conn.prepareStatement(query);
        ){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("Car ID: " + rs.getInt("cars_id") + " Customer Id " + rs.getInt("customer_id") + "Rental Date: " + rs.getDate("rental_date") + " Return Date: "
                + rs.getDate("return_date") + "Total Cost: " + rs.getDouble("total_price"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
}

