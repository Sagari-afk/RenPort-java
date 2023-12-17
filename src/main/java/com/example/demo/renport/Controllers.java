package com.example.demo.renport;

import com.example.demo.renport.models.Customer;
import com.example.demo.renport.models.Rental;
import com.example.demo.renport.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class Controllers {      // Class that catch api requests

    private final Service service;

    @Autowired
    public Controllers(Service service) {
        this.service = service;
    }

//    CUSTOMER
    @GetMapping(path = "/customer")
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }   // class to get all customers from db

    @GetMapping(path = "/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){   // class to get customer by specific id from db
        return service.getCustomerById(id);
    }

    @PostMapping(path = "/customer")
    public void registerNewCustomer(@RequestBody Customer customer) {   // class to add new customer to db
        service.addNewCustomer(customer);
    }

    @PutMapping(path = "/customer/{id}")
    public ResponseEntity<Object> editCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        // class to edit customer db (will find needed customer by id)
        return service.editCustomerById(id, customer);
    }

//    VEHICLE
    @GetMapping(path = "/vehicle")
    public List<Vehicle> getVehicles() {        // class to get all vehicles
        return service.getVehicles();
    }

    @GetMapping(path = "/vehicle/{vehicle}")
    public List<Vehicle> getVehiclesByType(@PathVariable String vehicle) {  // class to get all vehicles by its type
        return service.getAllVehiclesByType(vehicle);
    }

//    RENTAL
    @GetMapping(path = "/rental")
    public List<Rental> getRentals() {
        // class to get all rentals
        return service.getRentals();
    }

    @PostMapping(path = "/rental/{vehicleId}/{customerId}")
    public void registerNewRental(@RequestBody Rental rental, @PathVariable Long vehicleId, @PathVariable Long customerId) {
        // class to add new rental. use existing user and vehicle. one user can have some rentals(vehicles)
        rental.calculateDays();
        service.addNewRental(rental, vehicleId, customerId);
    }

}
