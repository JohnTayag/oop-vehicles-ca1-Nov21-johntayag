package org.example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BookingManager {
    private final ArrayList<Booking> bookingList;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;

    public BookingManager(String fileName, PassengerStore passengerStore, VehicleManager vehicleManager) {

        this.bookingList = new ArrayList<>();
        this.passengerStore = passengerStore;
        this.vehicleManager = vehicleManager;
        loadBookingsFromFile(fileName);
    }

    public void loadBookingsFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));

            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int bookingId = sc.nextInt();
                int passengerId = sc.nextInt();
                int vehicleId = sc.nextInt();
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                int hour = sc.nextInt();
                int minute = sc.nextInt();
                double startLatitude = sc.nextDouble();
                double startLongitude = sc.nextDouble();
                double endLatitude = sc.nextDouble();
                double endLongitude = sc.nextDouble();
                double cost = sc.nextDouble();

                bookingList.add(new Booking(passengerId, vehicleId, year, month, day, hour, minute,
                        startLatitude, startLongitude,
                        endLatitude, endLongitude, cost));

            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    public void add(int passengerId, int vehicleId, int year, int month, int day, int hour, int minute,
                    double startLatitude, double startLongitude,
                    double endLatitude, double endLongitude, double cost) {


        if (passengerStore.findPassengerbyId(passengerId) != null &&
                vehicleManager.findVehiclebyId(vehicleId) != null) {

            bookingList.add(new Booking(passengerId, vehicleId, year, month, day, hour, minute,
                    startLatitude, startLongitude,
                    endLatitude, endLongitude, cost));
        } else {
            System.out.println("Cannot find record!");
        }
    }

    public void add(int bookingId, int passengerId, int vehicleId, int year, int month,
                    int day, int hour, int minute,
                    double startLatitude, double startLongitude,
                    double endLatitude, double endLongitude, double cost) {


        if (passengerStore.findPassengerbyId(passengerId) != null &&
                vehicleManager.findVehiclebyId(vehicleId) != null) {

            bookingList.add(new Booking(bookingId, passengerId, vehicleId, year, month,
                    day, hour, minute,
                    startLatitude, startLongitude,
                    endLatitude, endLongitude, cost));
        }
    }

    //BookingManager methods
    public void DisplayAllBookings() {
        for (Booking b : bookingList) {
            System.out.println(b.toString());
        }
    }

    public Booking findBookingbyId(int id) {
        for (Booking b : bookingList) {
            if (b.getBookingId() == id) {
                return b;
            }
        }
        return null;
    }

    //passengerStore methods
    public void displayAllPassengers() {
        passengerStore.displayAllPassengers();
    }

    public void sortPassengersbyName() {
        passengerStore.SortPassengersbyName();
    }

    public void findPassengerByName(String name) {
        passengerStore.findPassengerByName(name);
    }

    public void addPassenger(String input_name, String email, String phonenumber, double latitude, double longtitude) {
        passengerStore.addPassenger(input_name, email, phonenumber, latitude, longtitude);
    }

    public void removePassenger(String name, String email) {
        passengerStore.deletePassenger(name, email);
    }

    //vehicleStore methods
    public void displayAllVehicles() {
        vehicleManager.displayAllVehicles();
    }

    public void displayVehiclesbyType(String type) {
        vehicleManager.displayVehiclesbyType(type);
    }

    public void displayVehiclesbySeats(int seats) {
        vehicleManager.displayVehiclesbySeats(seats);
    }

    public void findVehiclebyId(int id) {
        System.out.println("Vehicle with id " + id + ":" + vehicleManager.findVehiclebyId(id));
    }

    public void displayVehiclesbyMake(String make) {
        vehicleManager.displayVehiclesbyMake(make);
    }

    public void sortbyVehicleReg() {
        vehicleManager.sortbyVehicleReg();
    }

    @Override
    public String toString() {
        return "BookingManager{" +
                "bookingList=" + bookingList +
                '}';
    }
}
