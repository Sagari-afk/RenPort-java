package com.example.demo.renport.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ECar")
public class ECar extends Vehicle implements FuelVehicle{
    public ECar(String brand, String model, double pricePerDay, int speed, int fuelEconomy, boolean status, String vehicleType) {
        super(brand, model, pricePerDay, speed, fuelEconomy, "Fuel for eCar", status, vehicleType);
    }

    public ECar() {

    }

    public boolean refillVehicle() {
        fuelLevel = 100;
        return true;
    }
    public String getFillLevel() {
        return fuelLevel + "% kWatt";
    }
    public String getVehicleType() { return "ECar";}
}

