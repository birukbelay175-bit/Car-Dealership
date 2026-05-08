package com.pluralsight;
import java.util.ArrayList;
public class UserInterface {

        private Dealership dealership;

        public void display() {

            // load data from file
            init();

            // for now just print all vehicles
            processGetAllVehiclesRequest();
        }

        private void init() {
            DealershipFileManager fileManager = new DealershipFileManager();
            this.dealership = fileManager.getDealership();
        }

        public void processGetAllVehiclesRequest() {
            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
            displayVehicles(vehicles);
        }

        private void displayVehicles(ArrayList<Vehicle> vehicles) {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

