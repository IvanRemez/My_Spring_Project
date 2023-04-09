package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     // NOT Required anymore
            // same as @Service placed inside Service Impl class
            // No need for impl class as Spring Boot creates it implicitly
public interface CarRepository extends JpaRepository<Car, Long> {

// can you add your custom method here if JPA doesn't have one you need???
    // need somewhere to implement - Queries
}
