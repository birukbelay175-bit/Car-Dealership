package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public void display() {

        init();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n------ Car Dealership ------");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Find vehicles by price");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    processGetAllVehiclesRequest();
                    break;

                case 2:
                    processGetByPriceRequest();
                    break;

                case 99:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 99);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processGetByPriceRequest() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);

        displayVehicles(vehicles);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}