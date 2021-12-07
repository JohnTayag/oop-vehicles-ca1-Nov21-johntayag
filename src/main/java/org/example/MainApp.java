package org.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MainApp {
    PassengerStore passengerStore;  // encapsulates access to list of Passengers
    VehicleManager vehicleManager;  // encapsulates access to list of Vehicles
    BookingManager bookingManager;  // deals with all bookings

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.start();
    }

    public void start() {
        passengerStore = new PassengerStore("passengers.txt");
        vehicleManager = new VehicleManager("vehicles.txt");
        bookingManager = new BookingManager("bookinks.txt",passengerStore,vehicleManager);

        try {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }

        //   vehicleManager.displayAllVehicles();


        //   String registration = "172LH234106";
        //   Vehicle vehicle = vehicleManager.findVehicleByReg(registration);
        //   if (vehicle == null)
        //       System.out.println("No vehicle with registration " + registration + " was found.");
        //   else
        //       System.out.println("Found Vehicle: " + vehicle.toString());

        // Create BookingManager and load all bookings from file
        // bookingManager = new BookingManager("bookings.txt");

        //pMgr.saveToFile();

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Passengers\n"
                + "2. Vehicles\n"
                + "3. Bookings\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int PASSENGERS = 1;
        final int VEHICLES = 2;
        final int BOOKINGS = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case PASSENGERS:
                        System.out.println("Passengers option chosen");
                        displayPassengerMenu();
                        break;
                    case VEHICLES:
                        System.out.println("Vehicles option chosen");
                        displayVehicleMenu();
                        break;
                    case BOOKINGS:
                        System.out.println("Bookings option chosen");
                        displayBookingMenu();
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    private void displayPassengerMenu() {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Passengers\n"
                + "2. Find Passenger by Name\n"
                + "3. Add a Passenger\n"
                + "4. Delete a Passenger\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";

        final int SHOW_ALL = 1;
        final int FIND_BY_NAME = 2;
        final int ADD_PASSENGER = 3;
        final int DELETE_PASSENGER = 4;
        final int EXIT = 5;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL:
                        System.out.println("Display ALL Passengers");
                        bookingManager.sortPassengersbyName();
                        bookingManager.displayAllPassengers();
                        break;
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name = keyboard.nextLine();
                        bookingManager.findPassengerByName(name);
                        break;
                    case ADD_PASSENGER:
                        Scanner kb = new Scanner(System.in);
                        System.out.print("enter passenger name:");
                        String input_name = kb.nextLine();

                        System.out.print("enter passenger email:");
                        String email = kb.next();

                        System.out.print("enter passenger phoneNumber:");
                        String phoneNumber = kb.next();

                        System.out.print("enter passenger latitude:");
                        double latitude = kb.nextDouble();

                        System.out.print("enter passenger longtitude:");
                        double longtitude = kb.nextDouble();

                        bookingManager.addPassenger(input_name, email, phoneNumber, latitude, longtitude);
                        break;
                    case DELETE_PASSENGER:
                        System.out.println("Select passenger name you want to delete:");
                        String delete_name = keyboard.nextLine();
                        System.out.println("Select passenger email you want to delete:");
                        String delete_email = keyboard.nextLine();
                        bookingManager.removePassenger(delete_name,delete_email);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void displayVehicleMenu() {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Vehicles\n"
                + "2. Find Vehicle by Type\n"
                + "3. Find Vehicle by Number of Seats\n"
                + "4. Find Vehicle by Id\n"
                + "5. Find Vehicle by Make\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int SHOW_ALL = 1;
        final int FIND_BY_TYPE = 2;
        final int FIND_BY_SEATS = 3;
        final int FIND_BY_ID = 4;
        final int FIND_BY_MAKE = 5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL:
                        System.out.println("Display ALL Vehicles");
                        bookingManager.displayAllVehicles();
                        break;
                    case FIND_BY_TYPE:
                        System.out.println("Find Vehicles by Type");
                        System.out.println("Enter Vehicle type: ");
                        String type = keyboard.nextLine();
                        //sort using registration number
                        bookingManager.sortbyVehicleReg();
                        bookingManager.displayVehiclesbyType(type);
                        break;
                    case FIND_BY_SEATS:
                        System.out.println("Enter number of seats:");
                        int seats = keyboard.nextInt();
                        keyboard.nextLine();
                        //sort using registration number
                        bookingManager.sortbyVehicleReg();
                        bookingManager.displayVehiclesbySeats(seats);
                        break;
                    case FIND_BY_ID:
                        System.out.println("Enter car id:");
                        int id = keyboard.nextInt();
                        keyboard.nextLine();
                        bookingManager.findVehiclebyId(id);
                        break;
                    case FIND_BY_MAKE:
                        System.out.println("Enter car make:");
                        String make = keyboard.nextLine();
                        bookingManager.displayVehiclesbyMake(make);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void displayBookingMenu() {
        final String MENU_ITEMS = "\n*** BOOKING MENU ***\n"
                + "1. Show all Bookings\n"
                + "2. Add a Booking\n"
                + "3. Edit a Booking\n"
                + "4. Delete a Booking\n"
                + "5. Find Booking by Id\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int SHOW_ALL_BOOKINGS = 1;
        final int ADD_BOOKING = 2;
//        final int EDIT_BOOKING = 3;
//        final int DELETE_BOOKING = 4;
        final int FIND_BOOKING_BY_ID = 5;

        final int EXIT = 3;

        Scanner keyb = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyb.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {

                    case SHOW_ALL_BOOKINGS:
                        System.out.println("Display ALL Bookings");
                        bookingManager.DisplayAllBookings();
                        break;
                    case ADD_BOOKING:
//                        Scanner kb = new Scanner(System.in);
//
//                        System.out.print("enter passenger id:");
//                        int passenger_id = kb.nextInt();
//
//                        System.out.print("enter vehicle id:");
//                        int vehicle_id = kb.nextInt();
//
//                        System.out.print("enter year");
//                        int year = kb.nextInt();
//
//                        System.out.print("enter month");
//                        int month = kb.nextInt();
//                        System.out.print("enter day");
//                        int day = kb.nextInt();
//                        System.out.print("enter hour");
//                        int hour = kb.nextInt();
//                        System.out.print("enter minute");
//                        int minute = kb.nextInt();
//
//                        System.out.print("enter startLocation latitude:");
//                        double startLocation_Latitude = kb.nextDouble();
//
//                        System.out.print("enter startLocation longitude:");
//                        double startLocation_Longitude = kb.nextDouble();
//
//                        System.out.print("enter endLocation latitude:");
//                        double endLocation_Latitude = kb.nextDouble();
//
//                        System.out.print("enter endLocation longtitude:");
//                        double endLocation_Longitude = kb.nextDouble();
//
//                        System.out.print("enter booking cost:");
//                        double cost = kb.nextDouble();
//
//                        bookingManager.add(passenger_id, vehicle_id, year,month,day,
//                                hour,minute,
//                                startLocation_Latitude, startLocation_Longitude, endLocation_Latitude
//                                , endLocation_Longitude, cost);
                        bookingManager.add(101,105,2021,4,5,3,2,23.2,23.4,23.4,23.4,555);
                        break;
//                    case EDIT_BOOKING:
//
//                        break;
//                    case DELETE_BOOKING:
//
//                        break;
                    case FIND_BOOKING_BY_ID:
                        System.out.println("Enter Booking id:");
                        int id = keyb.nextInt();
                        keyb.nextLine();
                        System.out.println("Booking with id " + id + ":" + bookingManager.findBookingbyId(id));
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }


}
