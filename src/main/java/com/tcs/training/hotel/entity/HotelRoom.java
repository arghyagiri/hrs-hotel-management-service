package com.tcs.training.hotel.entity;

import com.tcs.training.hotel.model.RoomStatus;
import com.tcs.training.hotel.model.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOTEL_ROOMS")
public class HotelRoom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_sequence")
	@SequenceGenerator(name = "room_sequence", allocationSize = 100)
	private Long roomId;

	private Long customerId;

	@Column(nullable = false)
	private BigDecimal rent;

	@Column(nullable = false)
	private RoomStatus roomStatus;

	@Column(nullable = false)
	private RoomType roomType;

	@OneToMany
	@JoinColumn(name = "roomId")
	Set<RoomAmenity> amenities;

}
