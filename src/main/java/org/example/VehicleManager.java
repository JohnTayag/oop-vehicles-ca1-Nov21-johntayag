package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VehicleManager {
    private final ArrayList<Vehicle> vehicleList;

    public VehicleManager(String fileName) {
        this.vehicleList = new ArrayList<>();
        loadVehiclesFromFile(fileName);
    }

    public void loadVehiclesFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));

            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String type = sc.next();
                String make = sc.next();
                String model = sc.next();
                double milesPerKwH = sc.nextDouble();
                String registration = sc.next();
                double costPerMile = sc.nextDouble();
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                int mileage = sc.nextInt();
                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();

                if (type.equalsIgnoreCase("Van") || type.equalsIgnoreCase("Truck")) {
                    double loadspace = sc.nextDouble();
                    vehicleList.add(new Van(id, type, make, model, milesPerKwH,
                            registration, costPerMile,
                            year, month, day,
                            mileage, latitude, longitude,
                            loadspace));
                } else if (type.equalsIgnoreCase("Car") || type.equalsIgnoreCase("Fourxfour")) {
                    int seats = sc.nextInt();
                    vehicleList.add(new Car(id, type, make, model, milesPerKwH,
                            registration, costPerMile,
                            year, month, day,
                            mileage, latitude, longitude,
                            seats
                    ));
                }
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    public void displayAllVehicles() {
        for (Vehicle v : vehicleList)
            System.out.println(v.toString());
    }

    public ArrayList<Vehicle> findVehiclesbyMake(String make) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            if (v.getMake().equalsIgnoreCase(make)) {
                vehicles.add(v);
            }
        }

        sortbyVehicleReg(vehicles);
        return vehicles;
    }

    public ArrayList<Vehicle> findVehiclesbyType(String type) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            if (v.getType().equalsIgnoreCase(type)) {
                vehicles.add(v);
            }
        }

        sortbyVehicleReg(vehicles);
        return vehicles;
    }

    public ArrayList<Vehicle> findVehiclesbySeats(int seats) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            if (v instanceof Car) {
                if (((Car) v).getSeats() == seats) {
                    vehicles.add(v);
                }
            }
        }
        sortbyVehicleReg(vehicles);
        return vehicles;
    }

    public void sortbyVehicleReg(ArrayList<Vehicle> vehicles) {
        ComparatorVehicleRegsitration comp = new ComparatorVehicleRegsitration();
        Collections.sort(vehicles, comp);
    }

    public Vehicle findVehiclebyId(int id) {
        for (Vehicle v : vehicleList) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}