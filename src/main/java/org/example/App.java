package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class App {
    public static void main(String[] args) {

        PassengerStore passengerStore = new PassengerStore("passengers.txt");
        VehicleManager vehicleManager = new VehicleManager("vehicles.txt");
//        PassengerStore.displayAllPassengers();
//        PassengerStore.findPassengerByName("John Smith");

        int option = 0;

        while (option != 9) {
            //Bugged: when we read in the last double, it leaves the /n in the input stream and thus
            //the option reads this in
            Scanner kb = new Scanner(System.in);
            System.out.println("Press an option:");
            System.out.println("1. Add a passenger");
            System.out.println("2. Find Passenger By Name");
            System.out.println("3. Display All Vehicles");
            System.out.println("4. Get Vehicles By Id");
            System.out.println("5. Get Vehicles By Type");
            System.out.println("6. Get Vehicles By Make");
            System.out.println("7. Get Vehicles By Seats");
            System.out.println("8. Display List of All Passengers");
            option = parseInt(kb.nextLine());

            if (option == 1) {
                System.out.print("enter passenger name:");
                String name = kb.nextLine();


                System.out.print("enter passenger email:");
                String email = kb.next();

                System.out.print("enter passenger phonenumber:");
                String phonenumber = kb.next();

                System.out.print("enter passenger latitude:");
                double latitude = kb.nextDouble();

                System.out.print("enter passenger longtitude:");
                double longtitude = kb.nextDouble();

                for (int i = 0; i < passengerStore.getAllPassengers().size(); i++) {
                    if (passengerStore.getAllPassengers().get(i).getName().equals(name) &&
                            passengerStore.getAllPassengers().get(i).getEmail().equals(email)) {
                        System.out.println("FAIL! Two passengers can't have the same name AND email!");
                        break;
                    } else {
                        passengerStore.add(name, email, phonenumber, latitude, longtitude);
                        break;
                    }
                }
                passengerStore.displayAllPassengers();
            }
//            else if(option == 2){
//                System.out.println("Enter name of passenger you want to find");
//                String name = kb.next();
//                PassengerStore.findPassengerByName(name);
//            }
            else if (option == 3) {
                System.out.println("List of all Vehicles:");
                vehicleManager.displayAllVehicles();
            } else if (option == 4) {
                System.out.println("Enter car id:");
                int id = kb.nextInt();
                vehicleManager.getVehiclesbyId(id);
            } else if (option == 5) {
                System.out.println("Enter car type:");
                String type = kb.next();

                vehicleManager.getVehiclesbyType(type);
            } else if (option == 6) {
                System.out.println("Enter car make:");
                String make = kb.next();

                vehicleManager.getVehiclesbyMake(make);
            } else if (option == 7) {
                System.out.println("Enter number of seats:");
                int seats = kb.nextInt();

                vehicleManager.getVehiclesbySeats(seats);
            } else if (option == 8) {
                System.out.println("List of all Passengers:");
//                PassengerStore.displayAllPassengers();
            }
        }

        System.out.println("Program exiting... Goodbye");
    }


}
