package org.example.model;

public class Flat {

    private int flatNumber;
    private int rooms;
    private String floor;
    private double space;

    public Flat(int flatNumber, int rooms, String floor, double space) {
        this.flatNumber = flatNumber;
        this.rooms = rooms;
        this.floor = floor;
        this.space = space;
    }


    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatNumber=" + flatNumber +
                ", rooms=" + rooms +
                ", floor='" + floor + '\'' +
                ", space=" + space +
                '}';
    }
}
