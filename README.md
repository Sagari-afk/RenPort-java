# Vehicle Rental Service API Documentation

Welcome to the documentation for the Vehicle Rental Service API. This API provides functionality for managing vehicles, customers, and rentals in a vehicle rental service.


## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL Database
- Postman for API Testing



## Controllers:
Manages operations related to vehicles/rentals/customers.



## Endpoints:

GET /api/vehicles: Retrieve a list of all vehicles.
GET /api/vehicles/{id}: Retrieve details of a specific vehicle.
```
    @GetMapping(path = "/vehicle")
    public List<Vehicle> getVehicles() {        // class to get all vehicles
        return service.getVehicles();
    }

    @GetMapping(path = "/vehicle/{vehicle}")
    public List<Vehicle> getVehiclesByType(@PathVariable String vehicle) {  // class to get all vehicles by its type
        return service.getAllVehiclesByType(vehicle);
    }
```

GET /api/rental: Retrieve a list of all rentals.
POST /api/rental/{vehicleId}/{customerId}: Create a new rental.
```
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
```

GET /api/customer: Retrieve a list of all customers.
PUT /api/customer/{id}: Update details of a specific cusromer.
```
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
```



## Models:

**Vehicle**: An abstract class representing a vehicle. (The main part of class and explanation of code)
```
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

```

**Car**: Inherits from Vehicle, represents a car.

**ECar**: Inherits from Car, represents an electric car.

**Bike**: Inherits from Vehicle, represents a bike.

**EBike**: Inherits from Bike, represents an electric bike.

**Customer**: Represents a customer. (The main part of class and explanation of code)

**Rental**: Represents a rental transaction.



## Repositories:

**VehicleRepository**: Manages database operations for vehicles.

**CustomerRepository**: Manages database operations for customers.

**RentalRepository**: Manages database operations for rentals.


## Service Layer
The service layer is responsible for implementing business logic and managing the interaction between controllers and repositories. It plays a crucial role in maintaining separation of concerns within the application.

### For example:
```
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
```


## Running the Application
To run the Vehicle Rental Service API locally, follow these steps:

### 1. Clone the repository: 
`git clone <repository_url>`

### 2. Navigate to the project directory:
`cd <project_directory>`

### 3. Build the project: 
`./mvnw clean install`

### 4. Run the application: 
`./mvnw spring-boot:run`

### 5. API Testing with Postman
You can use Postman to test the API endpoints. Import the provided Postman collection file (VehicleRentalService.postman_collection.json) for a convenient set of pre-configured requests.



## Conclusion
Thank you for using the Vehicle Rental Service API. If you have any questions or issues, please refer to the documentation or contact our support team.
