package com.example.demo.renport.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class Bike extends Vehicle implements FuelVehicle{

    public Bike(String brand, String model, double pricePerDay, int speed, int fuelEconomy, boolean status, String vehicleType) {
        super(brand, model, pricePerDay, speed, fuelEconomy, "Fuel for bike", status, vehicleType);
    }

    public Bike() {

    }

    public boolean refillVehicle() {
        fuelLevel = 100;
        return true;
    }
    public String getFillLevel() {
        return fuelLevel + "% litres";
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }
}
