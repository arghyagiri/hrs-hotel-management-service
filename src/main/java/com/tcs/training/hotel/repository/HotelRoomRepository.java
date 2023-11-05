package com.tcs.training.hotel.repository;

import com.tcs.training.hotel.entity.HotelRoom;
import com.tcs.training.hotel.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

	List<HotelRoom> findByRoomStatus(RoomStatus roomStatus);

	HotelRoom findByRoomIdAndCustomerId(Long roomId, Long customerId);

}
