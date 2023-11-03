package com.tcs.training.hotel.repository;

import com.tcs.training.hotel.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

}
