package com.example.demo.renport.repositories;

import com.example.demo.renport.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// This annotation indicates that the interface is a Spring Data repository.
@org.springframework.stereotype.Repository
// This interface extends the JpaRepository interface provided by Spring Data JPA.
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
