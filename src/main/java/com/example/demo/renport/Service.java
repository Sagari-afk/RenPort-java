package com.example.demo.renport;

import com.example.demo.renport.models.Customer;
import com.example.demo.renport.models.Rental;
import com.example.demo.renport.models.Vehicle;
import com.example.demo.renport.repositories.CustomerRepository;
import com.example.demo.renport.repositories.RentalRepository;
import com.example.demo.renport.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public Service(CustomerRepository customerRepository, RentalRepository rentalRepository, VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        this.vehicleRepository = vehicleRepository;
    }

//    CUSTOMER
    public List<Customer> getCustomers(){
        return customerRepository.findAll();        // using spring finds all obj from needed table
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);     // finds by id
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);      // save into database
    }

    public ResponseEntity<Object> editCustomerById(Long id, Customer customer) {    // edit existing obj in table
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setSecondName(customer.getSecondName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());

        customerRepository.save(existingCustomer);
        return ResponseEntity.ok(existingCustomer);
    }

//    RENTAL
    public List<Rental> getRentals() {
        return rentalRepository.findAll();
    }

    public void addNewRental(Rental rental, Long vehicleId, Long customerId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setStatus(true);
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        rental.setVehicle(vehicle);
        rental.setCustomer(customer);
        System.out.println("___________________________");
        System.out.println(rental.getId());
        rentalRepository.save(rental);
    }



//    VEHICLE
    public List<Vehicle> getVehicles() {    // finds all objs in table
        return vehicleRepository.findAll();
    }

//    public void saveChangesOfValidation(Vehicle vehicle) {
//        vehicle = Validator.changeType(vehicle);
//        String type = Validator.validateVehicleType(vehicle);
//        vehicleRepository.updateVehicle(type, vehicle.getId());
//    }

    public List<Vehicle> getAllVehiclesByType(String type) {        // Sorting and return by vehicle type
        List<Vehicle> allByType = new ArrayList<>();
        for (Vehicle vehicle:vehicleRepository.findAll()){

            if (Objects.equals(vehicle.getVehicleType().toLowerCase(), type.toLowerCase())){
                allByType.add(vehicle);
            }
        }
        System.out.println(allByType);
        return allByType;
    }


}
