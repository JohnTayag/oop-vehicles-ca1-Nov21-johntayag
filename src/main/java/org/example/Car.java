package org.example;

public class Car extends Vehicle
{
    private double loadSpace;   // measured in litres.  For Vans and Trucks
    private int seats;

    public Car(String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude,
               int loadSpace,int seats)
    {
        // call superclass constructor to initialize the fields defined in Vehicle
        super(type,make,model,milesPerKwH,
                registration,costPerMile,
                year,month,day,
                mileage,latitude,longitude);

        this.loadSpace = loadSpace;
        this.seats = seats;
    }

    // Constructor version to be used to recreate a Van that was read from file.
    // It will have already been allocated an id.
    //
    public Car(int id, String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude,
               int loadSpace,int seats)
    {
        // call superclass constructor to initialize the fields defined in Vehicle
        super(id,type,make,model,milesPerKwH,
                registration,costPerMile,
                year,month,day,
                mileage,latitude,longitude);

        this.loadSpace = loadSpace;
        this.seats = seats;
    }

    public double getLoadSpace() {
        return loadSpace;
    }
    public void setLoadSpace(double loadSpace) {
        this.loadSpace = loadSpace;
    }

    public double getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Van{" +
                "loadSpace=" + loadSpace +
                + seats +
                "} " + super.toString();
    }
}
