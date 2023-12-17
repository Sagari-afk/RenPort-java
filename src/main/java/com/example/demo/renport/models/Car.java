package com.example.demo.renport.models;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle implements FuelVehicle {
    private String numberOfSeats;
    public Car(String brand, String model, double pricePerDay, int speed, int fuelEconomy, boolean status, String numberOfSeats, String vehicleType) {
        super(brand, model, pricePerDay, speed, fuelEconomy, "Fuel for car", status, vehicleType);
        this.numberOfSeats = numberOfSeats;
    }

    public Car() {}

    public boolean refillVehicle() {
        fuelLevel = 100;
        return true;
    }
    public String getFuelType() {
        return "Fuel for car";
    }
    public String getVehicleType() {
        return "Car";
    }
    public String getFillLevel() {
        return fuelLevel + "% litres";
    }
}
