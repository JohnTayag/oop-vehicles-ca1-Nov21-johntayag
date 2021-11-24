package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * This Vehicle Bookings Management Systems manages the booking of Vehicles
 * by Passengers.
 * <p>
 * This program reads from 3 text files:
 * "vehicles.txt", "passengers.txt", and "next-id-store.txt"
 * You should be able to see them in the project pane.
 * You will create "bookings.txt" at a later stage, to store booking records.
 * <p>
 * "next-id-store.txt" contains one number ("201"), which will be the
 * next auto-generated id to be used to when new vehicles, passengers, or
 * bookings are created.  The value in the file will be updated when new objects
 * are created - but not when objects are recreated from records in
 * the files - as they already have IDs.  Dont change it - it will be updated by
 * the IdGenerator class.
 */

public class App {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the VEHICLE BOOKINGS MANAGEMENT SYSTEM - CA1 for OOP\n");

        // create PassengerStore and load it with passenger records from text file
        PassengerStore passengerStore = new PassengerStore("passengers.txt");
        System.out.println("List of all passengers:");
        passengerStore.add("Mary Jones", "jonesm@gmail.com", "087-753845", 23.5656, -17.0012);
        passengerStore.displayAllPassengers();

        //ArrayList of passengers
        ArrayList<Passenger> ps1 = new ArrayList<Passenger>();
        Passenger p1 = new Passenger(573, "Jack Barry", "jbarry@gmail.com", "089-735621", 20.96, -19.18);
        Passenger p2 = new Passenger(174, "Jack Barry", "jbarry@gmail.com", "089-623414", 145.13, -59.31);


        //Edit,delete print details of any passenger
        System.out.println("ps1 email:" + p1.getEmail());

        p1.setLocation(12.6, 21.99);
        System.out.println("after set location of ps1:" + p1);

//        System.out.println("is ps1 equals to ps2"+  p1.equals(p2));

        //Deleting from arraylist
        delete(199, ps1);
        System.out.println("\nafter deleting id 199 from arraylist:");
        for (Passenger p : ps1) {
            System.out.println(p);
        }


        //Sorting passengers
        System.out.println("\nAfter sorting arraylist by name");
        ps1.add(p1);
        ps1.add(p2);
        ps1.add(new Passenger(647, "Ed Holmes", "dhl6@gmail.com", "089-424523", 62.62, -62.42));
        ps1.add(new Passenger(199, "Abe larkin", "abel@gmail.com", "088-426623", 36.62, -28.79));

        Collections.sort(ps1);
        for (Passenger p : ps1) {
            System.out.println(p);
        }


        //Vehicle
//        VehicleManager vehicleManager = new VehicleManager("vehicles.txt");
//        System.out.println("List of all Vehicles:");
//        vehicleManager.displayAllVehicles();
//
//        //Exit
//        System.out.println("Program exiting... Goodbye");


    }

    public static void delete(int id, ArrayList<Passenger> ps1) {
        for (int i = 0; i < ps1.size(); i++) {
            if (ps1.get(i).getId() == id) {
                ps1.remove(i);
            }
        }
    }
}
