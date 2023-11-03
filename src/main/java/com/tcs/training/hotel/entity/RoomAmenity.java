package com.tcs.training.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROOM_AMENITIES")
public class RoomAmenity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_amenities_sequence")
	@SequenceGenerator(name = "room_amenities_sequence", allocationSize = 100)
	private Long roomAmenityId;

	@Column(nullable = false)
	private Long noOfAmenity;

	@Column(nullable = false)
	private Long roomId;

	@Column(insertable=false, updatable=false)
	private Long amenityId;

	@OneToOne
	@JoinColumn(name = "amenityId")
	private Amenity amenity;

}
