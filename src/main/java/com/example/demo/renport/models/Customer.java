package com.example.demo.renport.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )

    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentalsOfCustomer;
    private String password;

    public Customer(String firstName, String secondName, String email, String phoneNumber, String password, List<Rental> rentals) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.rentalsOfCustomer = rentals;
    }

    public Customer(String firstName, String secondName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Rental> getRentalsOfCustomer() {
        return rentalsOfCustomer;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRentalsOfCustomer(List<Rental> rentalsOfCustomer) {
        this.rentalsOfCustomer = rentalsOfCustomer;
    }
}
