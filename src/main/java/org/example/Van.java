package org.example;

public class Van extends Vehicle
{
    private double loadSpace;

    public Van(String type, String make, String model, double milesPerKwH,
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

    public Van(int id, String type, String make, String model, double milesPerKwH,
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
        return "Van{" +
                "loadSpace=" + loadSpace +
                "} " + super.toString();
    }
}
