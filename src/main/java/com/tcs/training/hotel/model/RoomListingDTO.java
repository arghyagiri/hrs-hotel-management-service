package com.tcs.training.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomListingDTO {

	private Long roomId;

	private BigDecimal rent;

	private RoomType roomType;

	private RoomStatus roomStatus;

	private List<AmenityDTO> amenities;

}
