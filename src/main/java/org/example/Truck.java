package org.example;

public class Truck extends Vehicle
{
    private double loadSpace;

    //constructor without id
    public Truck(String type, String make, String model, double milesPerKwH,
                 String registration, double costPerMile,
                 int year, int month, int day,
                 int mileage, double latitude, double longitude,
                 double loadSpace)
    {

        super(type,make,model,milesPerKwH,
                registration,costPerMile,
                year,month,day,
                mileage,latitude,longitude);

        this.loadSpace = loadSpace;
    }

    //constructor with id
    public Truck(int id, String type, String make, String model, double milesPerKwH,
                 String registration, double costPerMile,
                 int year, int month, int day,
                 int mileage, double latitude, double longitude,
                 double loadSpace)
    {

        super(id,type,make,model,milesPerKwH,
                registration,costPerMile,
                year,month,day,
                mileage,latitude,longitude);

        this.loadSpace = loadSpace;
    }

    public double getLoadSpace() {
        return loadSpace;
    }

    public void setLoadSpace(double loadSpace) {
        this.loadSpace = loadSpace;
    }

    @Override
    public String toString() {
        return
//                "Truck{" +
                "loadSpace=" + loadSpace +
                "} " + super.toString();
    }
}
