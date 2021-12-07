package org.example;

import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle>{
    private IdGenerator idGenerator = IdGenerator.getInstance("next-id-store.txt");  // get access to the id Generator

    private int id;
    private String type;
    private String make;
    private String model;
    private double milesPerKwH;
    private String registration;
    private double costPerMile;
    private LocalDate lastServicedDate;
    private int mileage;
    private LocationGPS depotGPSLocation;

    public Vehicle(String type, String make, String model, double milesPerKwH, String registration, double costPerMile,
                   int year, int month, int day, int mileage, double latitude, double longitude) {
        this.id = idGenerator.getNextId();
        this.type = type;
        this.make = make;
        this.model = model;
        this.milesPerKwH = milesPerKwH;
        this.registration = registration;
        this.costPerMile = costPerMile;
        this.lastServicedDate = LocalDate.of(year, month, day);
        this.mileage = mileage;
        this.depotGPSLocation = new LocationGPS(latitude, longitude);
    }

    public Vehicle(int id, String type, String make, String model, double milesPerKwH, String registration, double costPerMile,
                   int year, int month, int day, int mileage, double latitude, double longitude) {
        this.id = id;
        this.type = type;
        this.make = make;
        this.model = model;
        this.milesPerKwH = milesPerKwH;
        this.registration = registration;
        this.costPerMile = costPerMile;
        this.lastServicedDate = LocalDate.of(year, month, day);
        this.mileage = mileage;
        this.depotGPSLocation = new LocationGPS(latitude, longitude);
    }

    public int getId() {
        return id;
    }

    private void setId() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMilesPerKm() {
        return milesPerKwH;
    }

    public void setMilesPerKm(double milesPerKm) {
        this.milesPerKwH = milesPerKm;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public double getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(double costPerMile) {
        this.costPerMile = costPerMile;
    }

    public LocalDate getLastServicedDate() {
        return lastServicedDate;
    }

    public void setLastServicedDate(LocalDate lastServicedDate) {
        this.lastServicedDate = lastServicedDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public LocationGPS getDepotGPSLocation() {
        return depotGPSLocation;
    }

    public void setDepotGPSLocation(double latitude, double longitude) {
        new LocationGPS(latitude, longitude);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
//                this.getClass().getSimpleName() +
                "{" + "id:" + this.id + ", type:" + type + ", make=" + make + ", model=" + model
                + ", milesPerKm=" + milesPerKwH + ", registration=" + registration
                + ", costPerMile=" + costPerMile + ", lastServicedDate="
                + lastServicedDate + ", mileage=" + mileage + ", depotGPSLocation="
                + depotGPSLocation + '}';
    }

    @Override
    public int compareTo(Vehicle other) {
        return this.getRegistration().compareTo(other.getRegistration());
    }

}
