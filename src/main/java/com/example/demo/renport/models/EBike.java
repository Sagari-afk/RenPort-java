package com.example.demo.renport.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EBike")
public class EBike extends Vehicle implements FuelVehicle{
    public EBike(String brand, String model, double pricePerDay, int speed, int fuelEconomy, boolean status, String vehicleType) {
        super(brand, model, pricePerDay, speed, fuelEconomy, "Fuel for eBike", status, vehicleType);
    }

    public EBike() {

    }

    public boolean refillVehicle() {
        fuelLevel = 100;
        return true;
    }
    public String getFillLevel() {
        return fuelLevel + "% kWatt";
    }
    public String getVehicleType() { return "EBike";}
}

