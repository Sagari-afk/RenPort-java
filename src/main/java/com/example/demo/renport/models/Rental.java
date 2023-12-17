package com.example.demo.renport.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @SequenceGenerator(
            name = "rental_sequence",
            sequenceName = "rental_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rental_sequence"
    )
    private Long id;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    private int days;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnds;
    @JsonBackReference
    @ManyToOne
    private Customer customer;

   /* public Rental(Vehicle vehicle, LocalDate dateStart, LocalDate dateEnds, Customer customer) {
        this.vehicle = vehicle;
        this.dateStart = dateStart;
        this.dateEnds = dateEnds;
        this.customer = customer;
        this.days = calculateDays(dateStart, dateEnds);
    }

    public Rental(Long vehicleId, LocalDate dateStart, LocalDate dateEnds, Long customerId) {
        this.dateStart = dateStart;
        this.dateEnds = dateEnds;
        this.days = calculateDays(dateStart, dateEnds);
    }*/

    public Rental() {}

    public int calculateDays(){
        Period between = Period.between(dateEnds, dateStart);
        this.days = Math.abs(between.getDays());
        return days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnds() {
        return dateEnds;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
