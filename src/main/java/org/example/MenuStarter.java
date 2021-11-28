package org.example;

import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MenuStarter {
    PassengerStore passengerStore;  // encapsulates access to list of Passengers
    VehicleManager vehicleManager;  // encapsulates access to list of Vehicles
    BookingManager bookingManager;  // deals with all bookings

    public static void main(String[] args) {
        MenuStarter app = new MenuStarter();
        app.start();
    }

    public void start() {
        // create PassengerStore and load all passenger records from text file
        passengerStore = new PassengerStore("passengers.txt");

        // create VehicleManager, and load all vehicles from text file
        vehicleManager = new VehicleManager("vehicles.txt");

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

    // Sub-Menu for Passenger operations
    private void displayPassengerMenu() {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Passengers\n"
                + "2. Find Passenger by Name\n"
                + "3. Add a Passenger\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int SHOW_ALL = 1;
        final int FIND_BY_NAME = 2;
        final int ADD_PASSENGER = 3;
        final int EXIT = 4;

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
                        passengerStore.displayAllPassengers();
                        break;
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name = keyboard.nextLine();
                        passengerStore.findPassengerByName(name);
                        break;
                    case ADD_PASSENGER:
                        Scanner kb = new Scanner(System.in);
                        System.out.print("enter passenger name:");
                        String input_name = kb.nextLine();


                        System.out.print("enter passenger email:");
                        String email = kb.next();

                        System.out.print("enter passenger phonenumber:");
                        String phonenumber = kb.next();

                        System.out.print("enter passenger latitude:");
                        double latitude = kb.nextDouble();

                        System.out.print("enter passenger longtitude:");
                        double longtitude = kb.nextDouble();

                        for (int i = 0; i < passengerStore.getAllPassengers().size(); i++) {
                            if (passengerStore.getAllPassengers().get(i).getName().equals(input_name) &&
                                    passengerStore.getAllPassengers().get(i).getEmail().equals(email)) {
                                System.out.println("FAIL! Two passengers can't have the same name AND email!");
                                break;
                            } else {
                                passengerStore.add(input_name, email, phonenumber, latitude, longtitude);
                                break;
                            }

                        }
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

    // Sub-Menu for Vehicle operations
    private void displayVehicleMenu() {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Vehicles\n"
                + "2. Find Vehicle by Type\n"
                + "3. Find Vehicle by Number of Seats\n"
                + "4. Find Vehicle by Id\n"
                + "5. Find Vehicle by Make\n"
                + "6. Exit\n"
                + "Enter Option [1,4]";

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
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL:
                        System.out.println("Display ALL Vehicles");
                        vehicleManager.displayAllVehicles();
                        break;
                    case FIND_BY_TYPE:
                        System.out.println("Find Vehicles by Type");
                        System.out.println("Enter Vehicle type: ");
                        String type = keyboard.nextLine();
                        //sort using registration number
                        vehicleManager.sortbyVehicleReg();
                        vehicleManager.getVehiclesbyType(type);
                        break;
                    case FIND_BY_SEATS:
                        System.out.println("Enter number of seats:");
                        int seats = keyboard.nextInt();
                        keyboard.nextLine();
                        //sort using registration number
                        vehicleManager.sortbyVehicleReg();
                        vehicleManager.getVehiclesbySeats(seats);
                        break;
                    case FIND_BY_ID:
                        System.out.println("Enter car id:");
                        int id = keyboard.nextInt();
                        keyboard.nextLine();
                        vehicleManager.getVehiclesbyId(id);
                        break;
                    case FIND_BY_MAKE:
                        System.out.println("Enter car make:");
                        String make = keyboard.nextLine();
                        vehicleManager.getVehiclesbyMake(make);
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
