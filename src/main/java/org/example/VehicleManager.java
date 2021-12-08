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

    public void displayVehiclesbyMake(String make) {
        for (Vehicle v : vehicleList) {
            if (v.getMake().equalsIgnoreCase(make)) {
                System.out.println("Details of vehicle with make " + make + ":" + v);
            }
        }
    }

    public void displayVehiclesbyType(String type) {
        for (Vehicle v : vehicleList) {
            if (v.getType().equalsIgnoreCase(type)) {
                System.out.println("Details of vehicle with type " + type + ":" + v);
            }
        }
    }

    public void displayVehiclesbySeats(int seats) {
        for (Vehicle v : vehicleList) {
            if (v instanceof Fourxfour) {
                if (((Fourxfour) v).getSeats() == seats) {
                    System.out.println("Details of vehicles with " + seats + " seats:" + v);
                }
            }
        }
    }

    public void sortbyVehicleReg() {
        ComparatorVehicleRegsitration comp = new ComparatorVehicleRegsitration();
        Collections.sort(vehicleList, comp);
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