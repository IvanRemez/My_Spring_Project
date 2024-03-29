package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

// Display all regions in Canada
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);  // same as ^^

// Display all regions with country names that include 'United'
    List<Region> findByCountryContaining(String country);

// Display all regions with country names that include 'United'
// IN Region ORDER
    List<Region> findByCountryContainsOrderByRegion(String country);

// Display top 2 regions in US
    List<Region> findTopByCountry(String country);  // top 1
    List<Region> findTop2ByCountry(String country); // top 2

    List<Region> findTopByCountryContainsOrderByRegion(String country);

}
