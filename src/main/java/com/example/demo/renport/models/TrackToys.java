package com.example.demo.renport.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TrackToys")
public class TrackToys extends Vehicle implements FuelVehicle{

    public TrackToys(String brand, String model, double pricePerDay, int speed, int fuelEconomy, boolean status, String vehicleType) {
        super(brand, model, pricePerDay, speed, fuelEconomy, "Fuel for track toys", status, vehicleType);
    }

    public TrackToys() {

    }

    public boolean refillVehicle() {
        fuelLevel = 100;
        return true;
    }
    public String getFillLevel() {
        return fuelLevel + "% litres";
    }
    public String getVehicleType() { return "TrackToys"; }
}

