//package com.example.demo.renport.models;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//public final class RentalSystem {
//    Vehicle[] vehicles = new Vehicle[0];
//
//    public static Customer addRental(Customer customer, Rental rental) {
//        Rental[] rentals = Arrays.copyOf(customer.getRentalsOfCustomer(), customer.getRentalsOfCustomer().length + 1);
//        rentals[rentals.length - 1] = rental;
//        customer.setRentalsOfCustomer(rentals);
//        return customer;
//    }
//
//    //    Vehicles
//    public Vehicle[] getAllVehicles() {return vehicles;}
//    public Vehicle findVehicleById(int id) {
//        return vehicles[id];
//    }
//
//    //    Filters
//    public Vehicle[] getBorrowAbleVehicles(){
//        Vehicle[] borrowAble = new Vehicle[0];
//        for (Vehicle vehicle:vehicles){
//            if (!vehicle.isStatus()){
//                borrowAble = Arrays.copyOf(borrowAble, borrowAble.length+1);
//                borrowAble[borrowAble.length -1] = vehicle;
//            }
//        }
//        return borrowAble;
//    }
//    public Vehicle[] getAllByTypeOfVehicle(String type) {
//        Vehicle[] allByType = new Vehicle[0];
//        for (Vehicle vehicle:vehicles){
//            if (vehicle.getClass().toString().equals(type)){
//                allByType = Arrays.copyOf(allByType, allByType.length +1);
//                allByType[allByType.length -1] = vehicle;
//            }
//        }
//        return allByType;
//    }
//
//    //    Create
//    public Rental createRental(int id, LocalDate dateStart, LocalDate dateEnds, Customer customer) {
//        return new Rental(findVehicleById(id), dateStart, dateEnds, customer);
//    }
//    public Customer createCustomer(String firstName, String secondName, String email, String phoneNumber) {
//        return new Customer(firstName, secondName, email, phoneNumber);
//    }
//}
