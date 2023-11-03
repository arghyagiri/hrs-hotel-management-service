package com.tcs.training.hotel.repository;

import com.tcs.training.hotel.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

}
