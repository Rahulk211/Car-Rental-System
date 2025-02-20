package com.carrentalsys;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarRentalSys car = new CarRentalSys();
        Rental rent = new Rental();
        Customers customer = new Customers();

        System.out.println("Welcome to Car Rental System");

        while (true) {
            System.out.println("1. Add Car");
            System.out.println("2. Delete Car");
            System.out.println("3. Rent car");
            System.out.println("4. Return car");
            System.out.println("5. View all cars");
            System.out.println("6. View all rentals");
            System.out.println("7. View all customers");
            System.out.println("8. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter model: ");
                    String model = sc.next();
                    System.out.print("Enter brand: ");
                    String brand = sc.next();
                    System.out.print("Enter price per day: ");
                    double price = sc.nextDouble();
                    car.addCars(model, brand, price);
                    break;

                case 2:
                    System.out.println("Enter Cars id");
                    int id = sc.nextInt();
                    car.deleteCar(id);
                    break;

                case 3:
                    System.out.println("******** Rent Car ********");
                    System.out.println("Enter customers name");
                    String name = sc.next();
                    System.out.println("Enter phone number:- ");
                    String phone = sc.next();
                    System.out.println("Enter Licence number:- ");
                    String l_no = sc.next();
                    customer.addCustomers(name, phone, l_no);

                    int c_id = customer.getCustomerId(name);
                    System.out.print("Enter car id: ");
                    int car_id = sc.nextInt();
                    System.out.print("Enter rental days: ");
                    int day = sc.nextInt();
                    rent.rentCar(c_id, car_id, day);
                    break;

                case 4:
                    System.out.print("Enter car id: ");
                    int cars_id = sc.nextInt();

                    rent.returnCar(cars_id);
                    break;

                case 5:
                    System.out.println("here is the List of all cars");
                    car.listAllCars();
                    break;

                case 6:
                    System.out.println("here is the List of all Rented cars");
                    rent.getRentedCars();
                    break;

                case 7:
                    System.out.println("here is the List of all customers");
                    customer.listAllCustomers();
                    break;

                case 8:
                    System.out.println("Existing System !!!");
                    return;

                default:
                    System.out.println("Invalid choice...");
            }
            sc.close();

        }

    }
}