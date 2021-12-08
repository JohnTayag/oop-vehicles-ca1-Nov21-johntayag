package org.example;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingManager {
    private final ArrayList<Booking> bookingList;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;
    Email email = new Email();
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

                bookingList.add(new Booking(bookingId, passengerId, vehicleId, year, month, day, hour, minute,
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

            System.out.println(email.sendReminderBookingMessage(passengerId, vehicleId, year, month, day, hour, minute,
                    startLatitude, startLongitude,
                    endLatitude, endLongitude, cost));

        } else {
            System.out.println("Cannot find passenger or vehicle on record!");
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

    //BOOKINGMANAGER METHODS
    public void DisplayAllBookings() {
        for (Booking b : bookingList) {
            System.out.println(b.toString());
        }
    }

    public void displayBookingsInFuture() {
        LocalDateTime now = LocalDateTime.now();
        for (Booking b : this.bookingList) {
            if (now.isBefore(b.getBookingDateTime()))
                System.out.println(b.toString());
        }
    }

    public Booking findBookingbyBookingId(int id) {
        for (Booking b : bookingList) {
            if (b.getBookingId() == id) {
                return b;
            }
        }
        return null;
    }

    public void deletebyBookingId(int id) {
        for (int j = 0; j < bookingList.size(); j++) {
            Booking obj = bookingList.get(j);
            if (obj.getBookingId() == id) {
                bookingList.remove(j);
            }
        }
    }

    public ArrayList<Booking> findBookingByPassengerId(int id) {
        ArrayList<Booking> bookings = new ArrayList<>();
        System.out.println("Bookings with passenger id " + id + ":");
        for (Booking b : bookingList) {
            if (b.getPassengerId() == id) {
                bookings.add(b);
            }
        }
        ComparatorBookingDateTime comp = new ComparatorBookingDateTime();
        Collections.sort(bookings, comp);
        return bookings;
    }

    public ArrayList<Booking> FindBookingsByPassengerName(String name) {
        int id = getPassengerIdbyName(name);
        ArrayList<Booking> bookings = new ArrayList<>();

        for (Booking b : bookingList) {
            if (b.getPassengerId() == id) {
                bookings.add(b);
            }
        }

        if (bookings.size() > 0) {
            System.out.println("Bookings with passenger name " + name + ":");
        } else {
            System.out.println("Cannot find booking with that passenger name");
        }

        ComparatorBookingDateTime comp = new ComparatorBookingDateTime();
        Collections.sort(bookings, comp);
        return bookings;
    }

    public boolean checkBoookingAvailability(int vehicleId, int year, int month, int day, int hour, int minute) {
        LocalDateTime addBookingDateTime = LocalDateTime.of(year, month, day, hour, minute);
        LocalDateTime now = LocalDateTime.now();
        boolean output = false;
        for (Booking b : bookingList) {
            if ((b.getBookingDateTime().equals(addBookingDateTime) && (b.getVehicleId() == vehicleId))
                    || addBookingDateTime.isBefore(now))
            {
                output = true;
            }
        }
        return output;
    }

    //PASSENGERSTORE METHODS
    public void displayAllPassengers() {
        passengerStore.displayAllPassengers();
    }

    public void displayPassengerByName(String name) {
        Passenger p = passengerStore.displayPassengerByName(name);
        if (p == null)
            System.out.println("No Passenger with name " + name + " was found.");
        else
            System.out.println("Found Passenger: " + p);
    }

    public void addPassenger(String input_name, String email, String phonenumber, double latitude, double longtitude) {
        passengerStore.addPassenger(input_name, email, phonenumber, latitude, longtitude);
    }

    public void deletePassenger(String name, String email) {
        passengerStore.deletePassenger(name, email);
    }

    public int getPassengerIdbyName(String name){
       int p = passengerStore.getPassengerIdByName(name);
       return p;
    }



    //VEHICLEMANAGER METHODS
    public void displayAllVehicles() {
        vehicleManager.displayAllVehicles();
    }

    public void displayVehiclesbyType(String type) {
        for (Vehicle v1 : vehicleManager.findVehiclesbyType(type)) {
            System.out.println(v1);
        }
    }

    public boolean doesVehicleTypeExist(String type){
        boolean output = true;
       if(vehicleManager.findVehiclesbyType(type).size()<=0){
           output = false;
       }
        return output;
    }

    public void findVehiclesbySeats(int seats) {
        for (Vehicle v1 : vehicleManager.findVehiclesbySeats(seats)) {
            System.out.println(v1);
        }
    }

    public void displayVehiclebyId(int id) {
        System.out.println("Vehicle with id " + id + ":" + vehicleManager.findVehiclebyId(id));
    }

    public void findVehiclesbyMake(String make) {
        for (Vehicle v1 : vehicleManager.findVehiclesbyMake(make)) {
            System.out.println(v1);
        }
    }

    @Override
    public String toString() {
        return "BookingManager{" +
                "bookingList=" + bookingList +
                '}';
    }
}
