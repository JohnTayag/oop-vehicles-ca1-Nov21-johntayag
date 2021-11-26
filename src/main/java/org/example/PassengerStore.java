package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



public class PassengerStore{

    private final ArrayList<Passenger> passengerList;

    public PassengerStore(String fileName) {
        this.passengerList = new ArrayList<>();
        loadPassengerDataFromFile(fileName);
    }

    public List<Passenger> getAllPassengers() {
        return this.passengerList;
    }

    public void displayAllPassengers() {
        for (Passenger p : passengerList) {
            System.out.println(p.toString());
        }
    }

    private void loadPassengerDataFromFile(String filename) {

        try {
            Scanner sc = new Scanner(new File(filename));
//           Delimiter: set the delimiter to be a comma character ","
//                    or a carriage-return '\r', or a newline '\n'
            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                String email = sc.next();
                String phone = sc.next();
                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();

                passengerList.add(new Passenger(id, name, email, phone, latitude, longitude));
            }


        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    public void add(String name, String email, String phone,
                    double latitude, double longitude) {
        passengerList.add(new Passenger(name, email, phone, latitude, longitude));
    }

    public void add(int id, String name, String email, String phone,
                    double latitude, double longitude) {
        passengerList.add(new Passenger(id, name, email, phone, latitude, longitude));
    }

    public void findPassengerByName(String name){
        for(Passenger p : passengerList){
            if(p.getName().equals(name)){
                System.out.println("Passengers with the name "+name+":"+p);
            }
        }
    }



}
