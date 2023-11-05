package com.tcs.training.hotel.controller;

import com.tcs.training.hotel.entity.Amenity;
import com.tcs.training.hotel.entity.RoomAmenity;
import com.tcs.training.hotel.entity.HotelRoom;
import com.tcs.training.hotel.model.RoomBookingRequest;
import com.tcs.training.hotel.model.RoomListingDTO;
import com.tcs.training.hotel.model.RoomStatus;
import com.tcs.training.hotel.repository.AmenityRepository;
import com.tcs.training.hotel.repository.RoomAmenityRepository;
import com.tcs.training.hotel.service.HotelManagementService;
import com.tcs.training.hotel.repository.HotelRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
public class HotelController {

	private final HotelManagementService hotelManagementService;

	private final HotelRoomRepository hotelRoomRepository;

	private final RoomAmenityRepository roomAmenityRepository;

	private final AmenityRepository amenityRepository;

	@GetMapping("/{id}")
	public HotelRoom getHotelById(@PathVariable Long id) {
		return hotelRoomRepository.getReferenceById(id);
	}

	@PostMapping("/create-listing")
	public HotelRoom addListing(@RequestBody RoomListingDTO roomListingDTO) {
		HotelRoom hotelRoom = hotelManagementService.addListing(roomListingDTO);
		return hotelRoomRepository.getReferenceById(hotelRoom.getRoomId());
	}

	@PostMapping("/update-listing")
	public HotelRoom updateListing(@RequestBody RoomListingDTO roomListingDTO) {
		HotelRoom hotelRoom = hotelManagementService.updateListing(roomListingDTO);
		return hotelRoomRepository.getReferenceById(hotelRoom.getRoomId());
	}

	@PostMapping("/reserve")
	public HotelRoom reserve(@RequestBody RoomBookingRequest hotelRoom) {
		return hotelManagementService.reserve(hotelRoom);
	}

	@PostMapping("/un-reserve")
	public HotelRoom unReserve(@RequestBody RoomBookingRequest hotelRoom) {
		return hotelManagementService.unReserve(hotelRoom);
	}

	@PostMapping("/book")
	public HotelRoom book(@RequestBody RoomBookingRequest hotelRoom) {
		return hotelManagementService.confirmBooking(hotelRoom);
	}

	@PostMapping("/cancel")
	public HotelRoom cancle(@RequestBody RoomBookingRequest hotelRoom) {
		return hotelManagementService.cancel(hotelRoom);
	}

	@PostMapping("/create-amenity")
	public Amenity addListing(@RequestBody Amenity amenity) {
		return amenityRepository.save(amenity);
	}

	@GetMapping("/amenities")
	public List<Amenity> getAmenities() {
		return amenityRepository.findAll();
	}

	@GetMapping("/room-amenities")
	public List<RoomAmenity> getRoomAmenities() {
		return roomAmenityRepository.findAll();
	}

	@GetMapping("/listings")
	public List<HotelRoom> getAvailableRooms() {
		return hotelRoomRepository.findByRoomStatus(RoomStatus.AVAILABLE);
	}

}
