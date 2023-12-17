package com.example.demo.renport.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;

// This annotation specifies the inheritance strategy for the entity.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// This annotation indicates that the class is an entity and is to be mapped to a database table.
@Entity
// This annotation specifies the name of the database table to which this entity is mapped.
@Table(name = "vehicle")
// This annotation defines the discriminator column for a single-table inheritance strategy.
@DiscriminatorColumn(
        // Specifies the type of the discriminator column, which determines the subclass type.
        discriminatorType = DiscriminatorType.STRING,
        // Specifies the name of the discriminator column in the database table.
        name = "Vehicle_type"
)

public abstract class Vehicle {         // main and abstract class - also model for db

    @Id // This annotation indicates that the field below is the primary key of the entity.

    @SequenceGenerator(
            // This annotation specifies the details of a sequence generator, which is used for generating unique identifiers.

            name = "vehicle_sequence",  // Name assigned to the generator, which can be referenced in other annotations.

            sequenceName = "vehicle_sequence",  // Name of the database sequence to be used by the generator.

            allocationSize = 1      // The amount by which the sequence value is incremented for each allocation.
    )

    @GeneratedValue(    // This annotation specifies the generation strategy for the annotated field.

            strategy = GenerationType.SEQUENCE, // Defines the strategy to be used for ID generation, in this case, using a sequence.

            generator = "vehicle_sequence"  // Specifies the name of the generator to be used for ID generation.
    )

    private Long id;
    private String brand;
    private String model;
    private double pricePerDay; //Price is always in euro
    private int speed; //Speed is always in km/h
    private int fuelEconomy;
    protected String fuelType;
    private boolean status;
    protected double fuelLevel = 0;
    protected String type;
    @JsonBackReference      // annotation that stop the loop
    @OneToOne(cascade = CascadeType.ALL)  // annotation for db that means one vehicle can have one rental and vice versa as well
    protected Rental rental;


    // constructor
    public Vehicle(String brand, String model, double pricePerDay, int speed, int fuelEconomy, String fuelType, boolean status, String vehicleType) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.speed = speed;
        this.fuelEconomy = fuelEconomy;
        this.fuelType = fuelType;
        this.fuelLevel = 0;
        this.status = status;
        this.type = vehicleType;
    }

    public Vehicle() {

    }


    // getters and setters
    public String getVehicleType() {
        return type;
    }

    public void setVehicleType(String vehicleType) {
        this.type = vehicleType;
    }

    public Long getId() {
        return id;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFuelEconomy(int fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFuelEconomy() {
        return fuelEconomy;
    }

    public boolean isStatus() {
        return status;
    }

    public double calculateRentalCost(double hours){
        return hours * pricePerDay;
    }


}
