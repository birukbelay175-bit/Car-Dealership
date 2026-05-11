package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice() >= min &&
                    vehicle.getPrice() <= max) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().trim().equalsIgnoreCase(make.trim())
                    && vehicle.getModel().trim().equalsIgnoreCase(model.trim())) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getYear() >= minYear
                    && vehicle.getYear() <= maxYear) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getColor().trim().equalsIgnoreCase(color.trim())) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getOdometer() >= minMileage
                    && vehicle.getOdometer() <= maxMileage) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getVehicleType().trim().equalsIgnoreCase(type.trim())) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }
}