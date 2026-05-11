 package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {

        init();

        int choice;

        do {

            System.out.println("\n------ Car Dealership ------");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Find vehicles by price");
            System.out.println("3 - Find vehicles by make/model");
            System.out.println("4 - Find vehicles by year");
            System.out.println("5 - Find vehicles by color");
            System.out.println("6 - Find vehicles by mileage");
            System.out.println("7 - Find vehicles by type");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    processGetAllVehiclesRequest();
                    break;

                case 2:
                    processGetByPriceRequest();
                    break;

                case 3:
                    processGetByMakeModelRequest();
                    break;

                case 4:
                    processGetByYearRequest();
                    break;

                case 5:
                    processGetByColorRequest();
                    break;

                case 6:
                    processGetByMileageRequest();
                    break;

                case 7:
                    processGetByTypeRequest();
                    break;

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
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

        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);

        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {

        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();

        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);

        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {

        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
  System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        displayVehicles(vehicles);
    }

    public void processGetByTypeRequest() {

        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(type);

        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {

        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(
                vin, year, make, model, type, color, odometer, price
        );

        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully.");
    }

    public void processRemoveVehicleRequest() {

        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {

            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            System.out.println("Vehicle removed successfully.");

        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        if (vehicles.size() == 0) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}