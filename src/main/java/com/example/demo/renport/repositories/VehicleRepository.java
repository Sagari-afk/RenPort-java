package com.example.demo.renport.repositories;

import com.example.demo.renport.models.Rental;
import com.example.demo.renport.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// This annotation indicates that the interface is a Spring Data repository.
@org.springframework.stereotype.Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // This interface extends the JpaRepository interface provided by Spring Data JPA.
//    @Modifying
//    @Query("UPDATE Vehicle v SET v.vehicleType = :vehicleType WHERE v.id = :id")
//    public void updateVehicle(@Param("vehicleType") String vehicleType, @Param("id") Long id);
}
