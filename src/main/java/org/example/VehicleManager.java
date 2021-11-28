package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VehicleManager{
    private final ArrayList<Vehicle> vehicleList;  // for Car and Van objects

    public VehicleManager(String fileName) {
        this.vehicleList = new ArrayList<>();
        loadVehiclesFromFile(fileName);
    }

    public void loadVehiclesFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
//           Delimiter: set the delimiter to be a comma character ","
//                    or a carriage-return '\r', or a newline '\n'
            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String type = sc.next();  // vehicle type
                String make = sc.next();
                String model = sc.next();
                double milesPerKwH = sc.nextDouble();
                String registration = sc.next();
                double costPerMile = sc.nextDouble();
                int year = sc.nextInt();   // last service date
                int month = sc.nextInt();
                int day = sc.nextInt();
                int mileage = sc.nextInt();
                double latitude = sc.nextDouble();  // Depot GPS location
                double longitude = sc.nextDouble();
                int loadspace = sc.nextInt();

                if (type.equalsIgnoreCase("Van") || type.equalsIgnoreCase("Truck")) {
                    // construct a Van object and add it to the passenger list
                    vehicleList.add(new Van(id, type, make, model, milesPerKwH,
                            registration, costPerMile,
                            year, month, day,
                            mileage, latitude, longitude,
                            loadspace));
                } else if (type.equalsIgnoreCase("Car") || type.equalsIgnoreCase("4x4")) {
                    // construct a Car object and add it to the passenger list
                    vehicleList.add(new Car(id, type, make, model, milesPerKwH,
                            registration, costPerMile,
                            year, month, day,
                            mileage, latitude, longitude,
                            loadspace
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

    public void getVehiclesbyId(int id) {
        for (Vehicle v : vehicleList) {
            if (v.getId() == id) {
                System.out.println("Details of vehicle with id " + id + ":" + v);
            }
        }
    }

    public void getVehiclesbyMake(String make) {
        for (Vehicle v : vehicleList) {
            if (v.getMake().equals(make)) {
                System.out.println("Details of vehicle with make " + make + ":" + v);
            }
        }
    }

    public void getVehiclesbyType(String type) {
        for (Vehicle v : vehicleList) {
            if (v.getType().equals(type)) {
                System.out.println("Details of vehicle with type " + type + ":" + v);
            }
        }
    }

    public void getVehiclesbySeats(int seats) {
        for (Vehicle v : vehicleList) {
            if (v instanceof Car) {
                if (((Car) v).getSeats() == seats) {
                    System.out.println("Details of vehicles with " + seats + " seats:" + v);
                }
            }
        }
    }

    public void sortbyVehicleReg(){
        ComparatorVehicleRegsitration comp = new ComparatorVehicleRegsitration();
        Collections.sort(vehicleList,comp);
    }
}
