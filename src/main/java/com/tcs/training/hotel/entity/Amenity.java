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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AMENITIES", uniqueConstraints = {
		@UniqueConstraint(name = "UC_AMENITIES", columnNames = { "name"}) })
public class Amenity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amenity_sequence")
	@SequenceGenerator(name = "amenity_sequence", allocationSize = 100)
	private Long amenityId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

}
