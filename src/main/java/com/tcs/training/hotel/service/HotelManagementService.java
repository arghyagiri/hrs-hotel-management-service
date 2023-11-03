package com.tcs.training.hotel.service;

import com.tcs.training.hotel.entity.Amenity;
import com.tcs.training.hotel.entity.HotelRoom;
import com.tcs.training.hotel.entity.RoomAmenity;
import com.tcs.training.hotel.model.RoomBookingRequest;
import com.tcs.training.hotel.model.RoomListingDTO;
import com.tcs.training.hotel.model.RoomStatus;
import com.tcs.training.hotel.repository.RoomAmenityRepository;
import com.tcs.training.hotel.repository.HotelRoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.tcs.training.model.exception.NoDataFoundException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelManagementService {

	private final HotelRoomRepository hotelRoomRepository;

	private final RoomAmenityRepository roomAmenityRepository;

	public HotelRoom updateListing(RoomListingDTO roomListingDTO) {
		return saveHotelRoomRecord(roomListingDTO, roomListingDTO.getRoomStatus());
	}

	public HotelRoom addListing(RoomListingDTO roomListingDTO) {
		return saveHotelRoomRecord(roomListingDTO, RoomStatus.AVAILABLE);
	}

	@Transactional
	public HotelRoom saveHotelRoomRecord(RoomListingDTO roomListingDTO, RoomStatus roomStatus) {
		HotelRoom hotelRoom = HotelRoom.builder()
			.roomStatus(roomStatus)
			.rent(roomListingDTO.getRent())
			.roomType(roomListingDTO.getRoomType())
			.build();
		hotelRoomRepository.save(hotelRoom);
		if (roomListingDTO.getAmenities() != null && !roomListingDTO.getAmenities().isEmpty()) {
			Set<RoomAmenity> roomAmenities = new HashSet<>();
			roomListingDTO.getAmenities().forEach(am -> {
				RoomAmenity roomAmenity = RoomAmenity.builder()
					.noOfAmenity(am.getNoOfAmenity())
					.amenity(Amenity.builder().amenityId(am.getAmenityId()).build())
					.roomId(hotelRoom.getRoomId())
					.build();
				roomAmenities.add(roomAmenity);
			});
			roomAmenityRepository.saveAll(roomAmenities);
		}
		return hotelRoom;
	}

	@Transactional
	public HotelRoom book(RoomBookingRequest roomBookingRequest) {
		HotelRoom room = hotelRoomRepository.getReferenceById(roomBookingRequest.getRoomId());
		if (room == null || (room != null && RoomStatus.BOOKED.equals(room.getRoomStatus()))) {
			throw new NoDataFoundException("Requested room is not found or not available at this moment.");
		}
		room.setRoomStatus(RoomStatus.BOOKED);
		room.setCustomerId(roomBookingRequest.getCustomerId());
		return hotelRoomRepository.save(room);
	}

	@Transactional
	public HotelRoom cancel(RoomBookingRequest roomBookingRequest) {
		HotelRoom room = hotelRoomRepository.getReferenceById(roomBookingRequest.getRoomId());
		if (room == null || (room != null && !RoomStatus.BOOKED.equals(room.getRoomStatus()))) {
			throw new NoDataFoundException("Requested room is not found or not available at this moment.");
		}
		room.setRoomStatus(RoomStatus.AVAILABLE);
		room.setCustomerId(null);
		return hotelRoomRepository.save(room);
	}

}
