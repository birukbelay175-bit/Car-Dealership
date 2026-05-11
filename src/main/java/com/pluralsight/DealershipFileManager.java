package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DealershipFileManager {

    private final String FILE_PATH = "src/main/resources/inventory.csv";

    public Dealership getDealership() {

        Dealership dealership = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));

            String dealershipLine = reader.readLine();

            if (dealershipLine != null) {
                String[] parts = dealershipLine.split("\\|");

                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);
            }

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(
                        vin, year, make, model, type, color, odometer, price
                );

                dealership.addVehicle(vehicle);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

            writer.write("D & B Used Cars|111 Old Benbrook Rd|817-555-5555");
            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice()
                );

                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}