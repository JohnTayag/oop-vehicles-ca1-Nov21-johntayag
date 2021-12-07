package org.example;

import java.util.Objects;

public class Passenger implements Comparable<Passenger> {
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocationGPS location;
    private IdGenerator idGenerator = IdGenerator.getInstance("next-id-store.txt");

    public Passenger(String name, String email, String phone,
                     double latitude, double longitude) {

        if (name == null)
            throw new IllegalArgumentException("null arguments encountered");

        this.id = idGenerator.getNextId();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = new LocationGPS(latitude, longitude);
    }

    public Passenger(int id, String name, String email, String phone,
                     double latitude, double longitude) {

        if (name == null)
            throw new IllegalArgumentException("null arguments encountered");

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = new LocationGPS(latitude, longitude);
    }

    public int getId() {
        return id;
    }

    private void setId() {
    }

    public String getName() {
        return name;
    }

    public LocationGPS getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLocation(double latitude, double longitude) {
        this.location = new LocationGPS(latitude, longitude);
    }

    @Override
    public String toString() {
//        return String.format("%11s", this.getClass().getSimpleName()) + String.format("%4s", "ID") + String.format("%8s", "Name")
//                + String.format("%25s", "Email") + String.format("%12s", "Phone") + String.format("%50s", "Location") + "\n"
//                + String.format("%15s", id);
        return String.format(id+String.format("%24s", name)+String.format("%27s", email)+String.format("%23s", phone)
        +String.format("%54s", location));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) && Objects.equals(email, passenger.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public int compareTo(Passenger other) {
        return this.name.compareTo(other.name);
    }

}
