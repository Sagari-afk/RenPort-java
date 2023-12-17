package com.example.demo.renport.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Camping")
public class Camping extends Vehicle implements FuelVehicle{

    public Camping(String brand, String model, double pricePerDay, int speed, int fuelEconomy, boolean status, String vehicleType) {
        super(brand, model, pricePerDay, speed, fuelEconomy, "Fuel for camping car", status, vehicleType);
    }

    public Camping() {

    }

    public boolean refillVehicle() {
        fuelLevel = 100;
        return true;
    }
    public String getFillLevel() {
        return fuelLevel + "% litres";
    }
    public String getVehicleType() { return "Camping";}
}
