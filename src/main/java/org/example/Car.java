package org.example;

public class Car extends Vehicle {
    private int seats;

    //constructor without id
    public Car(String type, String make, String model, double milesPerKwH, String registration, double costPerMile,
               int year, int month, int day, int mileage, double latitude, double longitude, int seats) {
        super(type, make, model, milesPerKwH, registration, costPerMile, year, month, day, mileage, latitude, longitude);
        this.seats = seats;
    }

    //constructor with id
    public Car(int id, String type, String make, String model, double milesPerKwH, String registration, double costPerMile,
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
//                "Car{" +
                "seats=" +
                seats +
                "} " + super.toString();
    }
}
