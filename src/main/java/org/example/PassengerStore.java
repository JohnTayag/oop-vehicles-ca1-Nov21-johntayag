package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class PassengerStore {

    private final List<Passenger> passengerList;

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

//    public void validatePassengerInput(String name, String email, String phone,
//                                       double latitude, double longitude){
//        for (int i = 0; i < name.length(); i++) {
//            if (name.charAt(i) >= 48 && name.charAt(i) <= 57) {
//                System.out.println("FAIL! Inputed a Number for a String!");
//            }
//        }
//    }
    public void addPassenger(String name, String email, String phone,
                    double latitude, double longitude) {

        for (int i = 0; i < passengerList.size(); i++) {
            if (passengerList.get(i).getName().equalsIgnoreCase(name) &&
                    passengerList.get(i).getEmail().equals(email)) {
                System.out.println("FAIL! Two passengers can't have the same name AND email!");
            }

            else
                {
                passengerList.add(new Passenger(name, email, phone, latitude, longitude));
                System.out.println("Added a Passenger!");
            }
            break;

        }

    }

    public void addPassenger(int id, String name, String email, String phone,
                    double latitude, double longitude) {
        for (int i = 0; i < passengerList.size(); i++) {
            if (passengerList.get(i).getName().equalsIgnoreCase(name) &&
                    passengerList.get(i).getEmail().equals(email)) {
                System.out.println("FAIL! Two passengers can't have the same name AND email!");
            } else {
                passengerList.add(new Passenger(id,name, email, phone, latitude, longitude));
                System.out.println("Added a Passenger!");
            }
            break;

        }

    }

    public void deletePassenger(String name, String email){
        for(int j = 0; j < passengerList.size(); j++) {
            Passenger obj = passengerList.get(j);
            if(obj.getName().equalsIgnoreCase(name)
            && obj.getEmail().equalsIgnoreCase(email)){
                passengerList.remove(j);
                break;
            }
        }
        }


    public void findPassengerByName(String name) {
        for (Passenger p : passengerList) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Passengers with the name " + name + ":" + p);
                System.out.println("Found passenger!");
            } else{
                System.out.println("No passenger matching the name \"" + name + "\"");
            }
            break;
        }
    }

    public Passenger findPassengerbyId(int id){
        for(Passenger p: passengerList){
            if(p.getId() == id){
                return p;
            }
        }
       return null;
    }

    public void SortPassengersbyName(){
        ComparatorPassengerName comp = new ComparatorPassengerName();
        Collections.sort(passengerList,comp);
    }
}