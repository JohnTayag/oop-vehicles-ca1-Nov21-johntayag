package org.example;

public class Fourxfour extends Vehicle {
    private int seats;

    //constructor without id
    public Fourxfour(String type, String make, String model, double milesPerKwH, String registration, double costPerMile,
                     int year, int month, int day, int mileage, double latitude, double longitude, int seats) {
        super(type, make, model, milesPerKwH, registration, costPerMile, year, month, day, mileage, latitude, longitude);
        this.seats = seats;
    }

    //constructor with id
    public Fourxfour(int id, String type, String make, String model, double milesPerKwH, String registration, double costPerMile,
                     int year, int month, int day, int mileage, double latitude, double longitude, int seats) {
        super(id, type, make, model, milesPerKwH, registration, costPerMile, year, month, day, mileage, latitude, longitude);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return
//                "Fourxfour{" +
                "seats=" +
                seats +
                "} " + super.toString();
    }
}
